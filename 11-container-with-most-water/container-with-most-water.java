class Solution {
    public int maxArea(int[] height) {
        int max = 0;

        int low = 0;
        int hi = height.length-1;

        while (low < hi) {
            int area = (hi-low) * Math.min(height[low], height[hi]);
            max = Math.max(max, area);
            
            if (height[low] <= height[hi]) {
                low++;
            } else if (height[low] > height[hi]) {
                hi--;
            }
        }
        return max;
    }
}