class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        dfs(nums, 0, new ArrayList<Integer>(), new HashSet<List<Integer>>());

        return res;
    }

    public void dfs(int[] nums, int i, List<Integer> subset, Set<List<Integer>> exists) {
        if (i == nums.length) {
            List<Integer> copy = new ArrayList<>(subset);
            Collections.sort(copy);

            if (!exists.contains(copy)) {
            res.add(new ArrayList<>(subset));
            exists.add(copy);
            }
            return;
        }

        subset.add(nums[i]);
        dfs(nums, i+1, subset, exists);
        subset.remove(subset.size() - 1);

        dfs(nums, i+1, subset, exists);
    }
}

