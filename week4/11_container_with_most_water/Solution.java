class Solution {
  public int maxArea(int[] height) {
    int res = 0;
    int leftPointer = 0;
    int rightPointer = height.length - 1;
    while (leftPointer < rightPointer) {
      int currArea = Math.min(height[leftPointer], height[rightPointer]) * (rightPointer - leftPointer);
      res = Math.max(res, currArea);
      if (height[leftPointer] < height[rightPointer]) {
        leftPointer++;
      } else {
        rightPointer--;
      }
    }
    return res;
  }
}
