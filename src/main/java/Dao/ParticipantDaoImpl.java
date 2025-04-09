package Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Model.Participant;
import Util.DBConnection;

public class ParticipantDaoImpl implements ParticipantDao {

    private Connection connection;

    public ParticipantDaoImpl() {
        try {
            connection = DBConnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addParticipant(Participant participant, int eventID) {
        String sql = "insert into participants (participantname, participanttype, eventid) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, participant.getName());
            stmt.setString(2, participant.getType());
            stmt.setInt(3, eventID);
            stmt.executeUpdate();
            System.out.println("Participant Added Successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding participant: " + e.getMessage());
        }
    }

    @Override
    public List<Participant> listParticipantsByEvent(int eventID) {
        List<Participant> participants = new ArrayList<>();
        String sql = "select * from participants WHERE eventid = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, eventID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                participants.add(new Participant(
                    rs.getString("participantname"),
                    rs.getString("participanttype")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return participants;
    }
}
