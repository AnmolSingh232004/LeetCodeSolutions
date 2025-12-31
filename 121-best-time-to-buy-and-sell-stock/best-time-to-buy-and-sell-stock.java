class Solution {
    public int maxProfit(int[] prices) {
        


        int l = 0;
        int r = 1;

        int maxProfit = 0; // records max profit

        while (r < prices.length && l < prices.length) {
            if (prices[l] > prices[r]) { 
                while (prices[l] <= prices[r])r++;
                l++;
            } else if (prices[l] <= prices[r]) {
                int localProfit = prices[r] - prices[l];
                maxProfit = Math.max(localProfit, maxProfit);
                r++;
            }

        }
        return maxProfit;
    }
}