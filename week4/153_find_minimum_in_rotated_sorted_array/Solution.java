class Solution {
  public int findMin(int[] nums) {
    int left = 0;
    int right = nums.length - 1;

    int mid;
    while (left < right) {
      mid = left + (right - left) / 2;
      if (nums[mid] > nums[right]) {
        left = mid + 1;
      } else {
        // We can ignore the case where nums[mid] == nums[left] since no dupes
        right = mid;
      }
    }
    return nums[left];
  }
  // Case 1: M is greater than R and L
  // [3,4,5,1,2]
  //        LMR

  // M is greater than R but less than L? no such situation, ascending order
  // [6,5,2] i.e., M is always greater than L

  // Case 2: M is greater than L but less than R
  // [1,2,3,4,5]
  // LR

  // Edge case: Single element (n = 1)
  // [5]
  // LMR

  // Edge case: Two elements (n = 2)
  // [4,5]
  // LMR
}