class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)return 0;

        Set<Integer> set = new HashSet<>();

        for (int i=0; i<nums.length; i++) {
            set.add(nums[i]);
        }

        int res = 0;

        for (int i=0; i<nums.length; i++) {
            int localRes = 0;

            if (!set.contains(nums[i] - 1)) { // checks if num - 1 exists in set or no, if no we execute
                int k = 0;
                while (set.contains(nums[i] + k)) {
                    localRes++;
                    set.remove(nums[i] + k);
                    k++;
                }
                res = Math.max(res, localRes);
        }
    }
    return res;
}
}