package Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Exception.InvalidPetAgeException;
import Exception.NullReferenceException;
import Model.Pet;
import Util.DBConnection;

public class PetDaoImpl implements PetDao {

    private Connection connection;

    public PetDaoImpl() {
        try {
            connection = DBConnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addPet(Pet pet) {
        String sql = "insert into pets (petID, name, age, breed, available) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            if (pet.getAge() <= 0) throw new InvalidPetAgeException("Pet age must be a positive integer.");
            stmt.setInt(1, pet.getPetID());
            stmt.setString(2, pet.getName());
            stmt.setInt(3, pet.getAge());
            stmt.setString(4, pet.getBreed());
            stmt.setBoolean(5, pet.isAvailable());
            stmt.executeUpdate();
            System.out.println("Pet Added Successfully!");
        } catch (Exception e) {
            System.out.println("Error adding pet: " + e.getMessage());
        }
    }

    @Override
    public void removePet(int petID) {
        String sql = "delete from pets WHERE petID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, petID);
            stmt.executeUpdate();
            System.out.println("Pet Removed Successfully!");
        } catch (SQLException e) {
            System.out.println("❗ Error removing pet: " + e.getMessage());
        }
    }

    @Override
    public List<Pet> listAvailablePets() {
        List<Pet> pets = new ArrayList<>();
        String sql = "select * from pets WHERE available = 1";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Pet pet = mapPet(rs);
                try {
                    if (pet.getName() == null || pet.getBreed() == null)
                        throw new NullReferenceException("Pet data missing.");
                    pets.add(pet);
                } catch (NullReferenceException e) {
                    System.out.println("Warning: " + e.getMessage());
                }
            }
        } catch (SQLException e) {
            System.out.println("Error fetching pets: " + e.getMessage());
        }
        return pets;
    }

    private Pet mapPet(ResultSet rs) throws SQLException {
        return new Pet(
            rs.getInt("petID"),
            rs.getString("name"),
            rs.getInt("age"),
            rs.getString("breed"),
            rs.getBoolean("available")
        );
    }
}
