package com.java.PetPal;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import Model.AdoptionEvent;
import Model.IAdoptable;
import java.util.List;

public class AdoptionEventTest {

    private AdoptionEvent event;
    private MockParticipant participant1;
    private MockParticipant participant2;

    class MockParticipant implements IAdoptable {
        String name;
        boolean adopted = false;

        public MockParticipant(String name) {
            this.name = name;
        }

        @Override
        public void adopt() {
            adopted = true;
        }

        public boolean isAdopted() {
            return adopted;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    @Before
    public void setUp() {
        event = new AdoptionEvent("Love & Paws Event");
        participant1 = new MockParticipant("Ravi");
        participant2 = new MockParticipant("Sneha");
    }

    @Test
    public void testRegisterParticipant() {
        event.registerParticipant(participant1);
        List<?> list = event.getParticipants();
        assertEquals(1, list.size());
        assertTrue(list.contains(participant1));
    }

    @Test
    public void testHostEventCallsAdopt() {
        event.registerParticipant(participant1);
        event.registerParticipant(participant2);

        event.hostEvent();

        assertTrue(participant1.isAdopted());
        assertTrue(participant2.isAdopted());
    }

    @Test
    public void testEventName() {
        assertEquals("Love & Paws Event", event.getEventName());
    }

    @Test
    public void testToStringOutput() {
        event.registerParticipant(participant1);
        String expected = "AdoptionEvent [eventName=Love & Paws Event, participants=[Ravi]]";
        assertEquals(expected, event.toString());
    }
}
