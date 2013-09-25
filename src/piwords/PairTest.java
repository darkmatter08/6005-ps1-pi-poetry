package piwords;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

public class PairTest {
    
    @Test
    public void testEquals(){
        Pair<Integer, String> pair1 = new Pair<Integer, String>(5, "hello");
        Pair<Integer, String> pair2 = new Pair<Integer, String>(5, "hello");
        Pair<Integer, String> pair3 = new Pair<Integer, String>(4, "hello");
        Pair<String, String> pair4 = new Pair<String, String>("hello", "world");
        
        assertTrue(pair1.equals(pair1));
        assertTrue(pair1.equals(pair2));
        assertTrue(pair2.equals(pair1));
        
        assertFalse(pair1.equals(pair3));
        assertFalse(pair3.equals(pair1));
        assertFalse(pair3.equals(pair2));
        
        assertFalse(pair4.equals(pair1));
    }
    
    @Test 
    public void testHashCode(){
        Pair<Integer, String> pair1 = new Pair<Integer, String>(40, "foo");
        Pair<Integer, String> pair2 = new Pair<Integer, String>(40, "foo");
        assertTrue(pair1.hashCode() == pair2.hashCode());
    }
    
    @Test
    public void testCompareTo(){
        Pair<Character, Integer> pair1 = new Pair<Character,Integer>('a', 2);
        Pair<Character, Integer> pair2 = new Pair<Character,Integer>('a', 3);
        assertTrue(pair1.compareTo(pair2) < 0);
    }

    @Test
    public void testCompareToSameObjs() {
        // Compare objects based on reference and state
        Calendar c1 = new GregorianCalendar(1111, 11, 11);
        Calendar c2 = (Calendar) c1.clone();
        Calendar c3 = new GregorianCalendar(2222, 22, 22);
        Pair<Calendar, Integer> pair1 =  new Pair<Calendar, Integer>(c1, 11);
        Pair<Calendar, Integer> pair2 =  new Pair<Calendar, Integer>(c2, 11);
        Pair<Calendar, Integer> pair3 =  new Pair<Calendar, Integer>(c2, 11);
        Pair<Calendar, Integer> pair4 =  new Pair<Calendar, Integer>(c2, 9);
        Pair<Calendar, Integer> pair5 =  new Pair<Calendar, Integer>(c3, 11);
        assertTrue(pair1.compareTo(pair2) == 0);
        assertTrue(pair2.compareTo(pair1) == 0);
        assertTrue(pair1.compareTo(pair3) == 0);
        assertTrue(pair1.compareTo(pair4) > 0);
        assertTrue(pair1.compareTo(pair5) < 0);
    }
}
