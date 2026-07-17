class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, 0, new ArrayList<>(), 0);
        return res;
    }

    public void dfs(int[] cand, int target, int i, List<Integer> comb, int sum) {
        if (sum > target || i >= cand.length)return;
        if (sum == target) {
            res.add(new ArrayList<>(comb));
            return;
        }

        comb.add(cand[i]);
        dfs(cand, target, i, comb, sum+cand[i]);

        comb.remove(comb.size() - 1);
        dfs(cand, target, i+1, comb, sum);
    }
}