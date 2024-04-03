class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1)return 0;
        int i = 1;
        int res = 0;
        int min = prices[0];
        while (i < prices.length) {
            res = Math.max(prices[i] - min, res);
            min = Math.min(min, prices[i]);
            i++;
        }
        if (res < 0)return 0;
        return res;
    }
}