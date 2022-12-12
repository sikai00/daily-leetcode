import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

class Solution {
  public boolean containsDuplicate(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int i : nums) {
      set.add(i);
    }
    return nums.length != set.size();
  }
}
