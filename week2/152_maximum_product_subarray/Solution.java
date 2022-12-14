class Solution {
  public int maxProduct(int[] nums) {
    int totalMax = nums[0];
    int max = nums[0];
    int min = nums[0];

    for (int i = 1; i < nums.length; i++) {
      int currMax = max;
      int currMin = min;
      max = Math.max(Math.max(nums[i], nums[i] * currMax), nums[i] * currMin);
      min = Math.min(Math.min(nums[i], nums[i] * currMax), nums[i] * currMin);
      totalMax = Math.max(max, totalMax);
    }

    return totalMax;
  }
}
