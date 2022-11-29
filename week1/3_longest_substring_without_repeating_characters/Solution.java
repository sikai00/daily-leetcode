/**
 * 3. Longest Substring Without Repeating Characters
 * 
 * Given a string s, find the length of the longest substring without repeating
 * characters.
 * 
 * Constraints:
 * 1. 0 <= s.length <= 5 * 104
 * 2. s consists of English letters, digits, symbols and spaces.
 */

/**
 * Solution:
 * 1. Brute force: Start from every single element --> O(n^2)
 * 2. 'Longest', 'Substring' --> Use sliding window technique to improve time
 * complexity to O(n)
 * 2a. Sliding window technique is accompanied with a map in HashMap.
 * Since symbols, etc. is allowed, cannot use array as a map.
 */

// sliding window:
// 1. move high pointer, add each character at high pointer until we notice a duplicate.
// 2. move low pointer pass the old duplicate

// set:
// 1. used as an auxiliary data structure to remember what characters we already have

// edge cases:
// s is empty
// sequence with 1 or 2 characters only
// * a   b
//   l   h
// p w w k e w
//     l     h   set: w k e   maxlength: 3

import java.util.Set;
import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        int highPointer = 0;
        int lowPointer = 0;

        while (highPointer < s.length()) {
            if (set.contains(s.charAt(highPointer))) {
                while (s.charAt(lowPointer) != s.charAt(highPointer)) {
                    set.remove(s.charAt(lowPointer));
                    lowPointer++;
                }
                // Remove the 'old' duplicate
                set.remove(s.charAt(lowPointer));
                lowPointer++;
            }

            set.add(s.charAt(highPointer));
            maxLength = Math.max(highPointer - lowPointer + 1, maxLength);
            highPointer++;
        }

        return maxLength;
    }
}
