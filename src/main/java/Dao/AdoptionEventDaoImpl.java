package Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Model.AdoptionEvent;
import Util.DBConnection;

public class AdoptionEventDaoImpl implements AdoptionEventDao {

    private Connection connection;

    public AdoptionEventDaoImpl() {
        try {
            connection = DBConnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createEvent(AdoptionEvent event) {
        String sql = "insert into adoptionevents (eventname, eventdate, location) VALUES (?, NOW(), ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, event.getEventName());
            stmt.setString(2, "Default location");
            stmt.executeUpdate();
            System.out.println("Event added Successfully!");
        } catch (SQLException e) {
            System.out.println("Error creating event: " + e.getMessage());
        }
    }

    @Override
    public List<AdoptionEvent> listEvents() {
        List<AdoptionEvent> list = new ArrayList<>();
        String sql = "select * from adoptionevents";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new AdoptionEvent(rs.getString("eventname")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
