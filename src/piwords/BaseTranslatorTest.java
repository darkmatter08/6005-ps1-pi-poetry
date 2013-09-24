package piwords;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Random;
import org.junit.Test;

public class BaseTranslatorTest {
    @Test
    public void basicBaseTranslatorTest() {
        // Expect that .01 in base-2 is .25 in base-10
        // (0 * 1/2^1 + 1 * 1/2^2 = .25)
        int[] input = {0, 1};
        int[] expectedOutput = {2, 5};
        assertArrayEquals(expectedOutput,
                          BaseTranslator.convertBase(input, 2, 10, 2));
    }

    @Test
    public void comprehensiveBaseTranslatorTests(){
        // 0b0.01111 = 0.132 (base 4) = 0.36 (base 8) = 0.612ac79461 (base 13) = 0x0.78 
        int[] input = {0, 1, 1, 1, 1};
        int[] base4 = {1, 3, 2};
        int[] base8 = {3, 6};
        int[] base13 = {6, 1, 2, 10, 12, 7};
        assertArrayEquals(input, BaseTranslator.convertBase(input, 2, 2, input.length));
        assertArrayEquals(base4, BaseTranslator.convertBase(input, 2, 4, base4.length));
        assertArrayEquals(base8, BaseTranslator.convertBase(input, 2, 8, base8.length));
        assertArrayEquals(base13, BaseTranslator.convertBase(input, 2, 13, base13.length));
        
        // length of digits varies
        int[] emptyArray = {};
        assertArrayEquals(emptyArray, BaseTranslator.convertBase(emptyArray, 3, 3, 0));
        
    }
    
    /**
     * Method that removes the trailing zeroes from an array, to allow array comparisons
     */
    private int[] stripTrailingZeroes(final int[] input){
        int[] noTrailingZeroes = Arrays.copyOf(input, input.length);
        int indexOfEarliestTrailingZero = noTrailingZeroes.length - 1;
        for(int i = indexOfEarliestTrailingZero; i > 0; i --){
            if(noTrailingZeroes[indexOfEarliestTrailingZero] != 0){
                indexOfEarliestTrailingZero++;
                break;
            }
        }
        return noTrailingZeroes;
    }
}
