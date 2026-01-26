class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1)return nums[0];
        int[] cache = new int[nums.length+1];

        for (int i=0; i<cache.length; i++) {
            cache[i] = -1;
        }
        int skipLast = dfs(nums, 0, nums.length-1, cache);

        for (int i=0; i<cache.length; i++) {
            cache[i] = -1;
        }
        int skipFirst = dfs(nums, 1, nums.length, cache);

        return Math.max(skipLast, skipFirst);

    }

    public int dfs(int[] nums, int start, int end, int[] cache) {
        if (start >= end)return 0;
        if (cache[start] != -1)return cache[start];

        int loot = nums[start] + dfs(nums, start+2, end, cache);
        int skip = dfs(nums, start+1, end, cache);

        cache[start] = Math.max(loot, skip);
        return cache[start];
    }
}

// We can jsut use the house robber concept but we will have 2 options
// either loost 1st and 2nd last house or 2nd and last house
// we can run 2 dfs recrusive calls 1st call will include 1st element but exclude last element
// 2nd call will exclude first element but include last element