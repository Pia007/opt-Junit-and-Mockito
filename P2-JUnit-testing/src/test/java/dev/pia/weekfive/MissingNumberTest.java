package dev.pia.weekfive;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 
1. Using assertEquals(), write some tests. Remember the naming conventions for tests: testFunctionName_Condition
 
*/

public class MissingNumberTest {

    private int[] minMissing = { 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    private int[] maxMissing = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    private int[] fiveMissing = { 1, 2, 3, 4, 6, 7, 8, 9, 10 };
    private int[] noneMissing = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

    private MissingNumber missing = new MissingNumber();
    
    @Test
    public void testingMissingNumber_MissingMin() {
        assertEquals(1, missing.missingNumber(minMissing, 10));
    }

    @Test
    public void testingMissingNumber_MissingMax() {
        assertEquals(10, missing.missingNumber(maxMissing, 10));
    }

    @Test
    public void testingMissingNumber_MissingFive() {
        assertEquals(5, missing.missingNumber(fiveMissing, 10));
    }

    @Test
    public void testingMissingNumber_NoMissing() {
        assertEquals(0, missing.missingNumber(noneMissing, 10));
    }

}
