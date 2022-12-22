  import java.util.Arrays;
  import java.util.List;
  import java.util.ArrayList;

  class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
      Arrays.sort(nums);
      List<List<Integer>> res = new ArrayList<>();
      for (int i = 0; i < nums.length; i++) {
        int lowPointer = i + 1;
        int highPointer = nums.length - 1;
        while (lowPointer < highPointer && (i == 0 || nums[i] != nums[i - 1])) {
          if (nums[i] + nums[lowPointer] + nums[highPointer] == 0) {
            List<Integer> subRes = Arrays.asList(nums[i], nums[lowPointer], nums[highPointer]);
            res.add(subRes);
            int tmpLow = nums[lowPointer];
            int tmpHigh = nums[highPointer];
            while (nums[lowPointer] == tmpLow && lowPointer < highPointer)
              lowPointer++;
            while (nums[highPointer] == tmpHigh && lowPointer < highPointer)
              highPointer--;
          } else if (nums[lowPointer] + nums[highPointer] + nums[i] < 0) {
            lowPointer++;
          } else {
            highPointer--;
          }
        }
      }
      return res;
    }
  }