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

    // TODO: Write more tests (Problem 5.a)
}
