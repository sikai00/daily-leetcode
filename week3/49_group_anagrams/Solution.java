import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    HashMap<Integer, List<String>> map = new HashMap<>();
    for (String str : strs) {
      int[] count = new int[26];
      for (char c : str.toCharArray()) {
        count[c - 97]++;
      }
      int hash = Arrays.hashCode(count);
      if (!map.containsKey(hash)) {
        map.put(hash, new ArrayList<>());
      }
      map.get(hash).add(str);
    }

    List<List<String>> res = new ArrayList<>();
    for (List<String> ls : map.values()) {
      res.add(ls);
    }
    return res;
  }
}
