class Solution {
  public boolean isAnagram(String s, String t) {
    int[] map = new int[26];
    for (char c : s.toCharArray()) {
      map[c - 97]++;
    }
    for (char c : t.toCharArray()) {
      map[c - 97]--;
    }
    for (int i = 0; i < map.length; i++) {
      if (map[i] != 0) {
        return false;
      }
    }
    return true;
  }
}