class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0)return 0;
        if (prices.length == 1)return 0;

        int l = 0;
        int r = 1;

        int maxProfit = 0;

        while (r < prices.length && l < prices.length) {
            if (prices[l] > prices[r]) { // 2 < 1
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