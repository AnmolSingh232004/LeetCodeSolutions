class Solution {
    int[] cache;
    public int rob(int[] nums) {
        cache = new int[nums.length+1];
        for (int i=0; i<nums.length; i++) {
            cache[i] = -1;
        }

        return dfs(nums, 0);
    }

    public int dfs(int[] nums, int i) {
        if (i >= nums.length)return 0;
        if (cache[i] != -1)return cache[i];

        int lootHouse = nums[i] + dfs(nums, i+2);

        int skipHouse = dfs(nums, i+1);

        cache[i] = Math.max(lootHouse, skipHouse);

        return Math.max(lootHouse, skipHouse);
    }
}