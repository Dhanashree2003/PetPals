package com.java.PetPal;

import static org.junit.Assert.*;
import org.junit.Test;
import Model.Pet;

public class PetTest {

    @Test
    public void testPetConstructorAndGetters() {
        Pet pet = new Pet(1, "Simba", 2, "Golden Retriever", true);

        assertEquals(1, pet.getPetID());
        assertEquals("Simba", pet.getName());
        assertEquals(2, pet.getAge());
        assertEquals("Golden Retriever", pet.getBreed());
        assertTrue(pet.isAvailable());
    }

    @Test
    public void testSetters() {
        Pet pet = new Pet();
        pet.setPetID(2);
        pet.setName("Mittens");
        pet.setAge(3);
        pet.setBreed("Persian");
        pet.setAvailable(false);

        assertEquals(2, pet.getPetID());
        assertEquals("Mittens", pet.getName());
        assertEquals(3, pet.getAge());
        assertEquals("Persian", pet.getBreed());
        assertFalse(pet.isAvailable());
    }

    @Test
    public void testToString() {
        Pet pet = new Pet(3, "Bella", 1, "Beagle", true);
        assertTrue(pet.toString().contains("Bella"));
        assertTrue(pet.toString().contains("Beagle"));
    }
}
