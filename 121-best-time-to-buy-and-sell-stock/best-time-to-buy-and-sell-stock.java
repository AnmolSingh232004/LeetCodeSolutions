class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0)return 0;

        int low = 0; // intialize a pointer low
        int hi = 1;

        int maxProfit = 0; // records max profit

        while (hi < prices.length) { // while right pointer is valid
            if (prices[low] > prices[hi]) { // if prices in present in more than in future in that case ce skip move into the future
                while (prices[low] <= prices[hi])hi++;
                low++;
            } else if (prices[low] < prices[hi]) { // if prices in present is cheaper than in future 
                int localProfit = prices[hi] - prices[low];
                maxProfit = Math.max(localProfit, maxProfit);
                hi++;
            } else {
                hi++;
                }

        }
        return maxProfit;
    }
}