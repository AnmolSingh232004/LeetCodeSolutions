class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid = left + (right-left)/2;
        while (left < right) {
            if (target > nums[mid]) {
                left = mid+1;
            } else if (target < nums[mid]) {
                right = mid-1;
            } else if (nums[mid] == target){
                return mid;
            }
            mid = left + (right-left)/2;
        }
        if (nums[mid] == target)return mid;
        return -1;
    }
}