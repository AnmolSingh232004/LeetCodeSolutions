class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();

        dfs(candidates, 0, target, list);
        return res;
    }

    public void dfs(int[] nums, int i, int target, List<Integer> list) {
        if (i == nums.length || target < 0) {
            return;
        }

        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[i]);
        dfs(nums, i, target - nums[i], list); // this just says include nums[i] again and again for one branch
        list.remove(list.size() - 1);
        dfs(nums, i+1, target, list); // this says for one branch ignore i forever and since we ignore i dont change target

    }
}