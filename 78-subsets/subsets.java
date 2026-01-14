class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> subset = new ArrayList<Integer>();

        dfs(nums, 0, subset);
        return res;
    }

    public void dfs(int[] nums, int i, List<Integer> subset) {
        if (i >= nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        dfs(nums, i+1, subset);

        subset.remove(subset.size() - 1);
        dfs(nums, i+1, subset);


    }
}