class Solution {
    public int maxArea(int[] height) {
        int max = 0;

        int low = 0;
        int hi = height.length-1;

        while (low < hi) {
            max = Math.max(max, (hi-low) * Math.min(height[low], height[hi]));
            
            if (height[low] < height[hi]) {
                low++;
            } else if (height[low] > height[hi]) {
                hi--;
            } else {
                hi--;
                low++;
            }
        }
        return max;
    }
}