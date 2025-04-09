package Dao;


import java.util.List;
import Model.Pet;

public interface PetDao {
    void addPet(Pet pet);
    void removePet(int petID);
    List<Pet> listAvailablePets();
   
}
