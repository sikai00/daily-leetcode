class Solution {
  public int maxProfit(int[] prices) {
    if (prices.length == 1) {
      return 0;
    }
    int currMaxProfit = 0;
    int buyPointer = 0;
    int sellPointer = 1;

    while (sellPointer < prices.length) {
      int currProfit = prices[sellPointer] - prices[buyPointer];
      if (currProfit < 0) {
        sellPointer++;
        buyPointer = sellPointer - 1;
      } else {
        sellPointer++;
        currMaxProfit = Math.max(currMaxProfit, currProfit);
      }
    }

    return currMaxProfit;
  }
}