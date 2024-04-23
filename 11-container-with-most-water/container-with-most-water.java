class Solution {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length-1;
        int res = 0;
        // dist for formula end - start;
        while (start <= end) {

            int small = Math.min(height[start], height[end]);
            int len = end - start;
            int localRes = small * len;
            res = Math.max(localRes, res);

            if (height[start] <= height[end]) {
                start++;
            } else if (height[start] > height[end]) {
                end--;
            }
            
        }
        return res;
    }
}