class Solution {
    int[] cache;

    public int minCostClimbingStairs(int[] cost) {
        cache = new int[cost.length+1];
        for (int i=0; i<=cost.length; i++) {
            cache[i] = -1;
        }
        int res1 = dfs(cost, 0, 0);
        int res2 = dfs(cost, 1, 0);

        return Math.min(res1, res2);
    }

    public int dfs(int[] cost, int i, int currCost) {
        if (i >= cost.length)return 0;
        if (cache[i] != -1)return cache[i];

        currCost = cost[i];
        

        int one = dfs(cost, i+1, currCost);
        int two = dfs(cost, i+2, currCost);
        cache[i] = currCost + Math.min(one, two);

        return currCost + Math.min(one, two);
    }
}