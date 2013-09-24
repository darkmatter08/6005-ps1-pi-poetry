package piwords;

import static org.junit.Assert.*;

import org.junit.Test;

import java.math.BigInteger;
import java.util.Arrays;

public class PiGeneratorTest {
    @Test
    public void basicPowerModTest() {
        // 5^7 mod 23 = 17
        assertEquals(17, PiGenerator.powerMod(5, 7, 23));

        // Cases with 0
        powerModTester(0, 3, 5);
        powerModTester(3, 0, 5);
        // Cases with 1
        powerModTester(1, 3, 5);
        powerModTester(3, 1, 5);
        powerModTester(3, 5, 1);
        // Cases with Integer.MAX_VALUE
        powerModTester(Integer.MAX_VALUE, 3, 5);
        powerModTester(3, Integer.MAX_VALUE, 5);
        powerModTester(3, 5, Integer.MAX_VALUE);
    }
    
    /**
     * Private method to help automate running test cases for powerMod. Using assertEquals
     * (base ^ exponent) % mod is equal to library implementation's result, will fail if it 
     * is not equal.
     * 
     * @param base Integer value satisfying preconditions of powerMod (base >= 0)
     * @param exponent Integer value satisfying preconditions of powerMod (exponent >= 0)
     * @param mod Integer value satisfying preconditions of powerMod (mod >= 0)
     */
    private static void powerModTester(final Integer base, final Integer exponent, final Integer mod){
        final int answerToEqual = new BigInteger(base.toString()).modPow(new BigInteger(exponent.toString()), new BigInteger(mod.toString())).intValue();
        assertEquals(answerToEqual, PiGenerator.powerMod(base, exponent, mod));
    }
    
    @Test
    public void computePiInHexTest() {
        assertArraysEquals(new int[]{2, 4, 3, 15, 6, 10, 8, 8, 8, 5, 10, 3, 0, 8, 13, 3, 1, 3, 1, 9, 8, 10, 2, 14, 0, 3, 7, 0, 7, 3, 4, 4, 10, 4, 0, 9, 3, 8, 2, 2, 2, 9, 9, 15, 3, 1, 13, 0, 0, 8}, PiGenerator.computePiInHex(50));
    }
    
    private void assertArraysEquals(int[] expected, int[] toTest){
        assertTrue(Arrays.equals(expected, toTest));
    }
}
