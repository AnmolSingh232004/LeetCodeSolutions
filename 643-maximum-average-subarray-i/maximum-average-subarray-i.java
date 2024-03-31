class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if (nums.length == 1)return (double)nums[0]/k;
        int start = 0;
        int end = k-1;
        double winVal = 0;
        for (int i=start; i<=end; i++) {
            winVal += (double)nums[i] / k;
        }
        double res = winVal;
        while (end < nums.length) {
            winVal -= ((double)nums[start]) / k;
            start++;
            end++;
            if (end < nums.length)winVal += ((double)nums[end]) / k;   
            else break;
            res = Math.max(res, winVal);
        }
        
        return res;
    }
}