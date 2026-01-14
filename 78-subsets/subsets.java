class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, list, res);
        return res;
    }

    public void dfs(int[] nums , int i, List<Integer> list, List<List<Integer>> res) {
        if (i >= nums.length) {
            res.add( new ArrayList<>(list));
            return;
        }

        list.add(nums[i]);
        dfs(nums, i+1, list, res);

        list.remove(list.size() - 1);
        dfs(nums, i+1, list, res);

    }
}

// we can generate all subsets if we initially start with 1st element on nums
// and do both the options 1 has initally 
// which is include 1 or not include 1 if it doesnt include we get [], if it does we  get [1]
// then [] can include 2 or not we get [2], []
// then [1] can [1,2], [1]
// [1,2] can include 3 | [1,2,3] or [1,2]
// like this we will get all possible subsets