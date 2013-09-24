package piwords;

import static org.junit.Assert.*;

import org.junit.Test;

public class DigitsToStringConverterTest {
    @Test
    public void basicNumberSerializerTest() {
        // Input is a 4 digit number, 0123 represented in base 4
        int[] input = {0, 1, 2, 3};

        // Want to map 0 -> "d", 1 -> "c", 2 -> "b", 3 -> "a"
        char[] alphabet = {'d', 'c', 'b', 'a'};

        String expectedOutput = "dcba";
        assertEquals(expectedOutput,
                     DigitsToStringConverter.convertDigitsToString(
                             input, 4, alphabet));
    }

    @Test
    public void invalidDigitsArrayTest(){
        // -1 in digits array
        int[] inputWithNeg = {0, 1, 2, -1};
        char[] alphabet = {'d', 'c', 'b', 'a'};
        try{
            DigitsToStringConverter.convertDigitsToString(
                    inputWithNeg, alphabet.length, alphabet);
        }catch(IllegalArgumentException e){
            assertTrue(true); //Only passes if this part of the code is reached, 
        }catch(Exception e){
            assertTrue(false); // Only executed if some other Exception is thrown (out of spec)
        }
        
        // value > base in digits array
        int[] inputOversizedValue = {0, 1, 2, 11};
        try{
            DigitsToStringConverter.convertDigitsToString(
                    inputOversizedValue, alphabet.length, alphabet);
        }catch(IllegalArgumentException e){
            assertTrue(true); //Only passes if this part of the code is reached, 
        }catch(Exception e){
            assertTrue(false); // Only executed if some other Exception is thrown (out of spec)
        }
    }
    
    @Test
    public void alphabetTests(){
        // Special Characters test
        char[] alphabet = {'/', '!', '@', '#', '$', '%', '^', '&', '|', '_', '_'};
        int[] input = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String expectedOutput = "/!@#$%^&|__";
        assertEquals(expectedOutput, DigitsToStringConverter.convertDigitsToString(
                             input, alphabet.length, alphabet));
        
    }
    
    @Test
    public void digitsLengthTests(){
        //length of digits is zero
        int[] input = {};
        char[] alphabet = {'d', 'c', 'b', 'a'};
        String expectedOutput = "";
        assertEquals(expectedOutput, DigitsToStringConverter.convertDigitsToString(
                             input, 4, alphabet));
    }
}
