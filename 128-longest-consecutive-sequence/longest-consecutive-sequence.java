class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;

        for (int i=0; i<nums.length; i++) {
            set.add(nums[i]);
        }

        for (int num : set) {
            int localRes = 0;
            int curr = 0;

            if (!set.contains(num - 1)) { // root element of any subsequence

            while (set.contains(num + curr)) {
            localRes++;
            curr++;
            }
            }
            res = Math.max(res, localRes);
            

        }
        return res;
    }
}