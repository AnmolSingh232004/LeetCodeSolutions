class Solution {
    int[] cache;
    public int climbStairs(int n) {
        cache = new int[n+1];
        for (int i=0; i<=n; i++) {
            cache[i] = -1;
        }
        return dfs(n, 0);
    }

    public int dfs(int n, int i) {
        if (i == n)return 1;
        if (i > n)return 0;
        if (cache[i] != -1)return cache[i];

        int left = dfs(n, i+1);
        int right = dfs(n, i+2);
        cache[i] = left + right;

        return cache[i];
    }
}