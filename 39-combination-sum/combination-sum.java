class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> comb = new ArrayList<>();
        dfs(candidates, 0, target, comb);
        return res;
    }

    public void dfs(int[] cand, int i, int target, List<Integer> comb) {
        if (i >= cand.length || target < 0) { // invalid combination
            return;
        }
        if (target == 0) { // valid combination found
        res.add(new ArrayList<>(comb));
        return;
        }

        comb.add(cand[i]);
        dfs(cand, i, target - cand[i], comb); // // stay at i to allow reuse of cand[i], other elements are still reachable later via skip calls.
        comb.remove(comb.size()-1);
        dfs(cand, i+1, target, comb); // // move to next index to permanently skip cand[i]; target unchanged because nothing was used


    }
}