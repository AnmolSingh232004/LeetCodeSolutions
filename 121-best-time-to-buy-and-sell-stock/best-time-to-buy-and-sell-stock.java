class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        int lo = 0;
        int hi = 1;

        while (hi < prices.length) {
            if (prices[lo] <= prices[hi]) {
                maxProfit = Math.max(maxProfit, prices[hi] - prices[lo]);
                hi++;
            } else {
                lo = hi;
            }
        }
        return maxProfit;
    }
}