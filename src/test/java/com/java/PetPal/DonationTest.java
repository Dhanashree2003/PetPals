package com.java.PetPal;

import static org.junit.Assert.*;
import org.junit.Test;
import java.time.LocalDateTime;

import Model.Donation;
import Model.DonationType;

public class DonationTest {

    @Test
    public void testConstructorAndGetters() {
        LocalDateTime now = LocalDateTime.now();
        Donation donation = new Donation("Arun", DonationType.CASH, 1000.0, null, now);

        assertEquals("Arun", donation.getDonorName());
        assertEquals(DonationType.CASH, donation.getDonationType());
        assertEquals(1000.0, donation.getDonationAmount(), 0.001);
        assertNull(donation.getDonationItem());
        assertEquals(now, donation.getDonationDate());
    }

    @Test
    public void testSetters() {
        Donation donation = new Donation("", null, 0.0, "", null);

        donation.setDonorName("Priya");
        donation.setDonationType(DonationType.ITEM);
        donation.setDonationAmount(0.0); // Cash ignored for item
        donation.setDonationItem("Pet Food");
        LocalDateTime now = LocalDateTime.now();
        donation.setDonationDate(now);

        assertEquals("Priya", donation.getDonorName());
        assertEquals(DonationType.ITEM, donation.getDonationType());
        assertEquals("Pet Food", donation.getDonationItem());
        assertEquals(now, donation.getDonationDate());
    }

    @Test
    public void testToStringNotNull() {
        Donation donation = new Donation("Ravi", DonationType.CASH, 500.0, null, LocalDateTime.now());
        assertNotNull(donation.toString()); // just checking it's not null or crashing
    }
}
