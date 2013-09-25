package piwords;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class AlphabetGeneratorTest {
    @Test
    public void generateAlphabetTest() {
        List<Pair<Character, Integer>> testInput = 
                new ArrayList<Pair<Character,Integer>>();
        testInput.add(new Pair<Character, Integer>('a', 4));
        testInput.add(new Pair<Character, Integer>('b', 4));
        testInput.add(new Pair<Character, Integer>('c', 2));
        
        char[] expectedOutput = {'a', 'a', 'a', 'a',
                                 'b', 'b', 'b', 'b',
                                 'c', 'c'};
        assertArrayEquals(expectedOutput,
                AlphabetGenerator.generateAlphabet(testInput));
    }

    @Test
    public void zeroAndRepeatedValuesTest() {
        List<Pair<Character, Integer>> testInput = 
                new ArrayList<Pair<Character,Integer>>();
        testInput.add(new Pair<Character, Integer>('a', 4));
        testInput.add(new Pair<Character, Integer>('b', 4));
        testInput.add(new Pair<Character, Integer>('c', 2));
        testInput.add(new Pair<Character, Integer>('y', 0));
        testInput.add(new Pair<Character, Integer>('c', 2));
        testInput.add(new Pair<Character, Integer>('!', 0));
        
        char[] expectedOutput = {'a', 'a', 'a', 'a',
                                 'b', 'b', 'b', 'b',
                                 'c', 'c', 'c', 'c'};
        assertArrayEquals(expectedOutput,
                AlphabetGenerator.generateAlphabet(testInput));
    }
    
    @Test
    public void specialCharactersTest() {
        List<Pair<Character, Integer>> testInput = 
                new ArrayList<Pair<Character,Integer>>();
        testInput.add(new Pair<Character, Integer>('/', 4));
        testInput.add(new Pair<Character, Integer>('%', 4));
        testInput.add(new Pair<Character, Integer>('|', 2));
        testInput.add(new Pair<Character, Integer>('}', 2));
        testInput.add(new Pair<Character, Integer>('{', 0));
        testInput.add(new Pair<Character, Integer>('_', 50));
        
        char[] expectedOutput = 
              { '%', '%', '%', '%', '/', '/', '/', '/', '_', '_', 
                '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', 
                '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', 
                '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', 
                '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', 
                '_', '_', '_', '_', '_', '_', '_', '_', '|', '|', 
                '}', '}' };
        assertArrayEquals(expectedOutput,
                AlphabetGenerator.generateAlphabet(testInput)); 
    }
}
