package com.java.PetPal;

import static org.junit.Assert.*;
import org.junit.Test;
import Model.Participant;

public class ParticipantTest {

    @Test
    public void testConstructorAndGetters() {
        Participant participant = new Participant("Lakshmi", "adopter");

        assertEquals("Lakshmi", participant.getName());
        assertEquals("adopter", participant.getType());
    }


    @Test
    public void testToString() {
        Participant p = new Participant("Riya", "adopter");
        String expected = "Participant [name=Riya, type=adopter]";
        assertEquals(expected, p.toString());
    }
}

