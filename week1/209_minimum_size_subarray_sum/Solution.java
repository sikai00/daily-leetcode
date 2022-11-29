/**
 * Given an array of positive integers nums and a positive integer target,
 * return the minimal length of a subarray whose sum is greater than or equal
 * to target.
 * 
 * If there is no such subarray, return 0 instead.
 * 
 * Constraints:
 * 
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 */

// Example:
// [1,2,3,4,5] target: 8 answer: 2
// [2,1,3,1] target: 8 answer: 0
// [2,1,3,1] target: 6 answer: 4

// At each point, ask: Is this the best I can do?

// Scaffolding:
// 1. Start with one low, one high pointer on index 0
// 2. As we increase high pointer, we add the value at the high pointer into
// // the current sum variable.
// 3. Once we reached our target sum, we can try to improve it by reducing
// // the number of elements being counted in.

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int lowPointer = 0;
        int highPointer = 0;
        int currentSum = 0;
        int minimumLength = Integer.MAX_VALUE;

        while (highPointer < nums.length) {
            currentSum += nums[highPointer];
            while (currentSum >= target) {
                minimumLength = Math.min(highPointer - lowPointer + 1, minimumLength);
                currentSum -= nums[lowPointer];
                lowPointer++;
            }
            highPointer++;
        }

        return minimumLength == Integer.MAX_VALUE ? 0 : minimumLength;
    }
}
