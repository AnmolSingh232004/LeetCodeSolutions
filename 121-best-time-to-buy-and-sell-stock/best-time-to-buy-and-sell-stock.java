class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;

        int low = 0;
        int hi = 1;
        
        int maxProfit = 0;
        // maximum profit achievable from one transaction

        while (hi < prices.length) {
            // scan prices from left to right

            if (prices[hi] < prices[low]) {
                // found a cheaper price than our current buy day
                // reset buy day to today
                low = hi;
            } else {
                // selling today is not worse than buying day
                // compute profit using the best buy day so far
                int localProfit = prices[hi] - prices[low];
                maxProfit = Math.max(maxProfit, localProfit);
            }

            // move to the next day
            hi++;
        }

        // final maximum profit after checking all days
        return maxProfit;
    }
}
