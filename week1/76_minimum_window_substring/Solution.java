import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t of lengths m and n respectively, return the minimum
 * window substring of s such that every character in t (including duplicates)
 * is included in the window. If there is no such substring, return the empty
 * string "".
 * 
 * The testcases will be generated such that the answer is unique.
 * 
 * Constraints:
 * 1. m == s.length
 * 2. n == t.length
 * 3. 1 <= m, n <= 105
 * 4. s and t consist of uppercase and lowercase English letters.
 */

// How to check if all the characters are included in O(1)?
// Sol: Use a counter variable to count down the number of characters. If the 
// current character high is pointing at is found in HashMap and has value 
// of >1, we decrease both that and the counter. Once counter has reached 0, 
// we know that we have fulfilled that requirement.

// Scaffolding:
// 1. Since we need to include dupes in t, we must use a HashMap to collect all
// // the characters in t.
// 2. We will use sliding window on s until all the characters in t are included
//    i. To check validity, use both the value in map and counter.
// 2b. If we reached the end of s while not all the characters in t are included
// // we will return an empty string.
// 3. Once we included all the characters (update resulting substring index), 
// // we need to do better.
//    i. We start by moving the low pointer up. As we do that, we check if the
//       character currently at low is in the map. If it is, we add 1 to the map
//       Furthermore, if the map value ends up being >0, we add 1 to counter.
//    ii. Everytime we move, we have to check for the substring's validity. 
//        We also maintain substring with two additional indexes.
//    iii. If it is no longer valid, move the higher pointer to find 
//         more characters.
// 4. We return the string at the result substring indexes.

// TEST:
// s: a  s  d  f  g         t: a f    ans: asdf
//       l     h
// map: (a:1, f:0)  characterReq: 1
// minimumLength: 4     currentLength: 4
// substringLow: 0     substringHigh: 3


// s: a  a  f  g      t: a f    ans: af
//       l  h
// map: (a:0, f:0)  characterReq: 0
// minimumLength: 3     currentLength: 3
// substringLow: 0     substringHigh: 2


// s: a  a   t: a a  ans: aa
//    lh
// outcome: """
// map: (a: 1)  characterReq: 2
// minimumLength: MAX     currentLength: 0
// substringLow: MAX     substringHigh: MIN

// Time complexity: O(m)
// 1. We do not ever move backwards.
// 2. Each character is only visited a maximum of twice.
// 3. n + m as it depends on whether s or t is larger. Optimisations can be made
// (in fact jumped from 24percentile to 66percentile)
// // By checking if size of t is greater than size of s.

class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();
        int characterRequirementCounter = t.length();
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }

        int lowPointer = 0;
        int highPointer = 0;

        int minimumLength = Integer.MAX_VALUE;
        int currentLength = 0;
        int substringLow = Integer.MAX_VALUE;
        int substringHigh = Integer.MIN_VALUE;

        while (highPointer < s.length()) {
            // Checking current character, if it fits requirement
            char currentChar = s.charAt(highPointer);
            if (map.containsKey(currentChar)) {
                map.put(currentChar, map.get(currentChar) - 1);
                if (map.get(currentChar) >= 0) {
                    characterRequirementCounter--;
                }
            }
            // Check if ready to get better
            while (characterRequirementCounter == 0 && map.get(currentChar) <= 0) {
                // Save the current length (we are aiming for minimum)
                currentLength = highPointer - lowPointer + 1;
                if (minimumLength > currentLength) {
                    minimumLength = currentLength;
                    substringLow = lowPointer;
                    substringHigh = highPointer;
                }
                // Move low pointer, try to get better results
                char lowPointerCharacter = s.charAt(lowPointer);
                if (map.containsKey(lowPointerCharacter)) {
                    map.put(lowPointerCharacter, map.get(lowPointerCharacter) + 1);
                    if (map.get(lowPointerCharacter) > 0) {
                        characterRequirementCounter++;
                    }
                }
                lowPointer++;
            }
            highPointer++;
        }

        return minimumLength == Integer.MAX_VALUE 
                ? "" 
                : s.substring(substringLow, substringHigh + 1);
    }
}
