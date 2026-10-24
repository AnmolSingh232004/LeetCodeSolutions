class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1)return nums[0];

        int hi = 1;

        int winValue = nums[0];
        int maxValue = winValue;

        while (hi < nums.length) {
            if (winValue < 0) {
                winValue = 0;
            }

            winValue += nums[hi];
            hi++;
            maxValue = Math.max(maxValue, winValue);
        }

        return maxValue;

    }
}

// We can make a sliding window
// We will have to make a logic for shrinkage, expansion will happen regardless
// For shrinkage if the value on the left side decreases overall window value we shrink otherwise we dont and we do this until we reach end