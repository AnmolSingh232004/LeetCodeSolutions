class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> perm = new ArrayList<>();
        boolean[] used = new boolean[nums.length]; // initally all false (false = not used)

        dfs(nums, perm, used);

        return res;
    }

    public void dfs(int[] nums, List<Integer> perm, boolean[] used) {
        if (perm.size() == nums.length) { // perm reaches max size means correct perm built
            res.add(new ArrayList<>(perm));
            return;
        }

        for (int i=0; i<nums.length; i++) {

            if ( !used[i] ) { // used[i] is independent of for loop order since it uses true/false to determine what to use
                perm.add(nums[i]); // add this one to perm
                used[i] = true; // this is now used 
                dfs(nums, perm, used); // explore all for this now

                used[i] = false; // all explored now backtrack and make it usable again
                perm.remove(perm.size() - 1); // remove from perm to finsih backtrack
            }


        }
    }
}

// we can for every element explore all possible outcomes by adding every elemenet possible to it
// i.e for 1,2,3 
// 1 = [1], [1,2], [1,3], [1,2,3], [1,3,2]
// 2 = [2], [2,1], [2,3], [2,1,3], [2,3,1]
// 3 = [3], [3,1], [3,2], [3,1,2], [3,2,1]

// Like this we can build these permutations, what basically is happening is for 1 we explore all possiblistes and do everything possible so for nums[i] we add all elements one by one
// for [1] add 2 and 3
// we can add our permutation to answer when perm.len = nums.len which = 3 in ex:

// we have to also identify which element is used for that we need to get a boolean array of nums.len
// if a number is used for 1 permutation make it true, and process it fully then make it false again
// true means nums[i] used false means not used

