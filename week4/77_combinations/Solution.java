import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> res = new ArrayList<>();
    backtrack(res, new ArrayList<>(), 1, n, k);
    return res;
  }
  
  public void backtrack(List<List<Integer>> res, List<Integer> curr, int start, int n, int k) {
    if (curr.size() == k) {
      res.add(new ArrayList<>(curr));
    } else {
      for (int i = start; i <= n; i++) {
        curr.add(i);
        backtrack(res, curr, i + 1, n, k);
        curr.remove(curr.size() - 1);
      }
    }
  }
}