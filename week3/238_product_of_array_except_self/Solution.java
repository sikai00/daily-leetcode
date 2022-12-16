class Solution {
  public int[] productExceptSelf(int[] nums) {
    int[] leftToRight = new int[nums.length];
    leftToRight[0] = 1;
    for (int i = 1; i < nums.length; i++) {
      leftToRight[i] = nums[i - 1] * leftToRight[i - 1];
    }

    int[] rightToLeft = new int[nums.length];
    rightToLeft[nums.length - 1] = 1;
    for (int i = nums.length - 2; i >= 0; i--) {
      rightToLeft[i] = nums[i + 1] * rightToLeft[i + 1];
    }

    int[] res = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      res[i] = leftToRight[i] * rightToLeft[i];
    }

    return res;
  }

  // [2,4,3,3] ans: [36,18,24,24]
  // lToR: [1,2,8,24]
  // rTol: [36,9,3,1]
  // isolate each element. 
  // lToR shows us the product of elements to its left; 
  // rTol shows us the product of elements to its right.
  // For example, at index 1, lToR has 2, which is correct, 2 is the product.
  // rToL has 9, which is correct since 3 x 3 = 9.
  // By pre-calculating the elements to the left and the right of the current element,
  // and tagging it to the original element, we can easily derive the products of 
  // the elements EXCEPT itself, by multiplying the two pre-calculated array at the original
  // position.

  // Example run through: [2,4,3,3]
  // lToR: [1,2,8,24]
  // rToL: [36,9,3,1]
}