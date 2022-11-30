/**
 * Given a string s, return the number of palindromic substrings in it.
 * 
 * A string is a palindrome when it reads the same backward as forward.
 * 
 * A substring is a contiguous sequence of characters within the string.
 * 
 * Constraints:
 * 
 * 1. 1 <= s.length <= 1000
 * 2. s consists of lowercase English letters.
 */

class Solution {
    public int countSubstrings(String s) {
        int palindromicSubstringCount = 0;
        for (int i = 0; i < s.length(); i++) {
            // Check odd core
            int left = i;
            int right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                palindromicSubstringCount++;
                left--;
                right++;
            }
            // Check even core
            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                palindromicSubstringCount++;
                left--;
                right++;
            }
        }
        return palindromicSubstringCount;
    }
}