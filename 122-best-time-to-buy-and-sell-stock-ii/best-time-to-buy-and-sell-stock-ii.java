class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;

        for (int i=0; i<prices.length-1; i++) {
            if (prices[i] < prices[i+1]) { // if today is cheap and tmw is expensive
                profit -= prices[i]; // buy today
                profit += prices[i+1]; // sell tmw
            }
        }
        return profit;
    }
}

// so we can sell and buy on same day
// to maximize profit we can just buy today if its cheaper than tmw and then sell it immediately next day
