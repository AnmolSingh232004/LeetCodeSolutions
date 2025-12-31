class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0)return 0;

        int low = 0; // intialize a pointer low
        int hi = 1;

        int maxProfit = 0; // records max profit

        while (hi < prices.length) {
            if (prices[low] > prices[hi]) { 
                while (prices[low] <= prices[hi])hi++;
                low++;
            } else if (prices[low] <= prices[hi]) {
                int localProfit = prices[hi] - prices[low];
                maxProfit = Math.max(localProfit, maxProfit);
                hi++;
            }

        }
        return maxProfit;
    }
}