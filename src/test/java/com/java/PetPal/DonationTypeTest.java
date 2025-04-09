package com.java.PetPal;

import static org.junit.Assert.*;
import org.junit.Test;
import Model.DonationType;

public class DonationTypeTest {

    @Test
    public void testEnumValues() {
        DonationType[] values = DonationType.values();

        assertEquals(2, values.length);
        assertEquals(DonationType.CASH, DonationType.valueOf("CASH"));
        assertEquals(DonationType.ITEM, DonationType.valueOf("ITEM"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidEnumValueThrowsException() {
        DonationType.valueOf("FOOD"); // should throw IllegalArgumentException
    }
}
