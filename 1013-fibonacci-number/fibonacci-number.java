class Solution {
    int[] cache;
    public int fib(int n) {
        cache = new int[n+1];
        for (int i=0; i<=n; i++) {
            cache[i] = -1;
        }
        return dfs(n);
    }

    public int dfs(int n) {
        if (n == 0)return 0;
        if (n == 1)return 1;
        if (cache[n] != -1)return cache[n]; 

        cache[n] = dfs(n-1) + dfs(n-2);

        return dfs(n-1) + dfs(n-2);
    }
}