package piwords;

import java.util.HashMap;
import java.util.Map;

public class WordFinder {
    /**
     * Given a String (the haystack) and an array of Strings (the
     * needles), return a Map<String, Integer>, where keys in the map
     * correspond to elements of `needles' that were found as
     * substrings of `haystack', and the value for each key is the
     * lowest index of `haystack' at which that needle was found. A
     * needle that was not found in the haystack should not be
     * returned in the output map.
     *
     * For example, let haystack = "abaaaaba" and needles = {"ab", "aaaa", "bb"};
     * then findWords would return {"ab" -> 0, "aaaa" -> 2}.
     * 
     * @param haystack The string to search in.
     * @param needles The array of strings to search for. This array
     *                is not mutated. No element of this array may be
     *                empty ("") or null.
     * @return A map associating each needle that was found in the
     *         haystack with the lowest index of the haystack at which
     *         that needle was found.
     */
    public static Map<String, Integer> findWords(String haystack,
                                                 String[] needles) { 
        Map<String, Integer> result = new HashMap<String, Integer>();
        for(int i = 0; i < haystack.length(); i++){
            for(String needle : needles){
                int endIndex = i + needle.length();
                // endIndex cannot be past end of string and if substring is equal to the needle
                if(endIndex <= haystack.length() && 
                        haystack.substring(i, endIndex).equals(needle)){
                    if(!result.containsKey(needle))
                        result.put(needle, i);
                }
            }
        }
        return result;
    }
}
