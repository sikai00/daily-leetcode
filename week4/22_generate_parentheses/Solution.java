import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<String> generateParenthesis(int n) {
    List<String> res = new ArrayList<>();
    backtrack(res, "", 0, 0, n);
    return res;
  }
  
  public void backtrack(List<String> list, String curr, int openCount, int closeCount, int n) {
    if (openCount == n && closeCount == n) {
      list.add(curr);
    } else {
      if (openCount <= n) {
        backtrack(list, curr + "(", openCount + 1, closeCount, n);
      }
      if (closeCount <= n && openCount > closeCount) {
        backtrack(list, curr + ")", openCount, closeCount + 1, n);
      }
    }
  }
}