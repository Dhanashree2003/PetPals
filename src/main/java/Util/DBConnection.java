package Util;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBConnection {

    private static Connection connection = null;

    public static Connection getConnection() {
        try {
            ResourceBundle rb = ResourceBundle.getBundle("PetPals");
            String driver = rb.getString("driver");
            String url = rb.getString("url");
            String user = rb.getString("user");
            String pwd = rb.getString("password");

            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, pwd);
            System.out.println("Database connection successful.");
            
        }
        
        catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found. Check your driver in classpath.");
        } 
        catch (SQLException e) {
            System.out.println("Failed to connect to the database: " + e.getMessage());
        } 
        catch (Exception e) {
            System.out.println("Unexpected error during DB connection: " + e.getMessage());
        }
        return connection;
    }
}
