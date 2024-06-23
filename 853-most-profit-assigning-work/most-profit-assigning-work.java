class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Arrays.sort(worker);
        int w = 0;
        int totalProfit = 0;

        for (int i=0; i<profit.length; i++) {
            int localProfit = 0;
            for (int j=0; j<profit.length; j++) {
                if (w < worker.length && worker[w] - difficulty[j] >= 0) // worker max difficulty job
                localProfit = Math.max(localProfit, profit[j]);
            }
            if (w < worker.length)w++;
            else break;
            totalProfit += localProfit;
        }
        return totalProfit;
    }
}