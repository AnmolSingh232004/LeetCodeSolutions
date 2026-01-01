class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        int lo = 0; // left pointer, aka past
        int hi = 1; // right pointer, aka future

        while (hi < prices.length) {
            if (prices[lo] <= prices[hi]) { // if stock was cheap in past and expensive in future calc local profit and move hi
                maxProfit = Math.max(maxProfit, prices[hi] - prices[lo]); // local profit vs maxProfit 
                hi++; // move hi since its buying at hi will give loss 100%
            } else if (prices[lo] > prices[hi]) { // if stock is expensive today than future then we move our lo to hi 
                lo = hi; // move to lo to hi
            }
        }
        return maxProfit;
    }
}