class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, target, list);
        return res;
    }

    public void dfs(int[] nums, int i, int target, List<Integer> list) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        if (target < 0 || i == nums.length)return;

        
        list.add(nums[i]);
        dfs(nums, i+1, target - nums[i], list);
        list.remove(list.size() - 1);

        while (i < nums.length-1 && nums[i] == nums[i+1])i++;
        dfs(nums, i+1, target, list);


    }
}

// to skip duplicates we can sort our initial array
// in 3 sum problem we made sure if we got an answer from i = 1
// we never use the same i for that itteration we can use that here
// we look at current element, if it is same as next element we skip until current != new