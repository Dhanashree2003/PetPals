package Dao;

import Model.Donation;
import Model.DonationType;
import Util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DonationDaoImpl implements DonationDao {

    private Connection connection;

    public DonationDaoImpl() {
        try {
            connection = DBConnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void recordDonation(Donation donation) {
        String sql = "insert into donations (donorname, donationtype, donationamount, donationitem, donationdate) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, donation.getDonorName());
            stmt.setString(2, donation.getDonationType().toString().toLowerCase());

            if (donation.getDonationType() == DonationType.CASH) {
                stmt.setDouble(3, donation.getDonationAmount());
                stmt.setNull(4, Types.VARCHAR);
            } else {
                stmt.setNull(3, Types.DOUBLE);
                stmt.setString(4, donation.getDonationItem());
            }

            stmt.setTimestamp(5, Timestamp.valueOf(donation.getDonationDate()));
            stmt.executeUpdate();
            System.out.println("Donation recorded successfully.");
        } catch (SQLException e) {
            System.out.println("Error recording donation: " + e.getMessage());
        }
    }

    @Override
    public List<Donation> listDonations() {
        List<Donation> list = new ArrayList<>();
        String sql = "select * from Donations";

        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Donation donation = new Donation(
                        rs.getString("donorname"),
                        DonationType.valueOf(rs.getString("donationtype").toUpperCase()),
                        rs.getDouble("donationamount"),
                        rs.getString("donationitem"),
                        rs.getTimestamp("donationdate").toLocalDateTime()
                );
                list.add(donation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
