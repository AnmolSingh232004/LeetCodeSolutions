class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];
        prefix[0] = 1;

        for (int i=1; i<nums.length; i++) {
            prefix[i] = prefix[i-1] * nums[i-1];
        }

        postfix[postfix.length-1] = 1;
        for (int i=postfix.length-2; i>=0; i--) {
            postfix[i] = postfix[i+1] * nums[i+1];
        }

        int[] res = new int[nums.length];

        for (int i=0; i<nums.length; i++) {
            res[i] = postfix[i] * prefix[i];
        }

        return res;
    }
}

// We can make 2 prefix and postfix array
// prefix at nums[i] will have multiplicative value of every element to left of nums[i] and not nums[i] itself
// postfix will do it for right

// [1,1,2,6]
// [24,12,4,1]
// Simple rule is this prefix = prefix[i-1] * nums[i-1]
// postfix = postfix[i+1] * nums[i+1]