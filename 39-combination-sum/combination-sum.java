class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, 0, new ArrayList<>());
        return res;
    }

    public void dfs(int[] cand, int target, int i, List<Integer> comb) {
        if (target < 0 || i >= cand.length)return;
        if (target == 0) {
            res.add(new ArrayList<>(comb));
            return;
        }

        comb.add(cand[i]);
        dfs(cand, target - cand[i], i, comb);

        comb.remove(comb.size() - 1);
        dfs(cand, target, i+1, comb);
    }
}