class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)return 0;
        Arrays.sort(nums);
        int max = 1;
        int curr = 0;
        for (int i=0; i<nums.length-1; i++) { // 0,1,1,2
        if (nums[i] == nums[i+1])continue;
            if (nums[i]+1 == nums[i+1]) {
                if (curr == 0)curr++;
                curr++;
            } // 0,0,1,2,3,3,125
            else {
            max = Math.max(curr, max);
            curr = 0;
            }
        }
        max = Math.max(curr, max);
        
        return max;
    }
}