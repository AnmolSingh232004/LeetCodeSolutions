class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];

        for (int i=1; i<nums.length; i++) {
            prefix[i] = prefix[i-1] * nums[i]; 
        }

        int[] postfix = new int[nums.length];
        postfix[nums.length-1] = nums[nums.length-1];

        for (int i=nums.length-2; i >= 0; i--) {
            postfix[i] = nums[i] * postfix[i+1];
        }

        for (int i=0; i<nums.length; i++) {
            if (i == 0) {
                nums[i] = postfix[i+1];
            } else if (i == nums.length-1) {
                nums[i] = prefix[i-1];
            } else {
                nums[i] = prefix[i-1] * postfix[i+1];
            }
        }
        return nums;
    }
}