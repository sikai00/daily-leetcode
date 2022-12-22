import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class Solution {
  public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, (x, y) -> {
      if (x[0] < y[0]) {
        return -1;
      } else if (x[0] > y[0]) {
        return 1;
      } else {
        return 0;
      }
    });

    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < intervals.length; i++) {
      // last interval
      if (i == intervals.length - 1) {
        res.add(Arrays.asList(intervals[i][0], intervals[i][1]));
        break;
      }
      // check if overlap
      if (intervals[i][1] >= intervals[i + 1][0]) {
        // need to merge
        intervals[i + 1] = new int[] { intervals[i][0], Math.max(intervals[i][1], intervals[i + 1][1]) };
      } else {
        res.add(Arrays.asList(intervals[i][0], intervals[i][1]));
      }
    }

    int[][] resArr = new int[res.size()][2];
    for (int i = 0; i < res.size(); i++) {
      resArr[i] = res.get(i).stream().mapToInt(Integer::intValue).toArray();
    }

    return resArr;
  }
}
