class Solution {
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length-1;

        int mid = lo + (hi - lo) / 2;
        int min = nums[mid];

        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;

            if (mid+1 < nums.length && nums[mid+1] < nums[mid]) {
                return nums[mid+1];
            } 

            if (mid-1 >= 0 && nums[mid-1] > nums[mid]) {
                return nums[mid];
            }

            if (nums[mid] <= nums[lo]) {
                min = Math.min(min, nums[mid]);
                min = Math.min(min, nums[lo]);
                hi = mid - 1;
            } else if (nums[mid] > nums[lo]) {
                min = Math.min(min, nums[mid]);
                min = Math.min(min, nums[lo]);
                lo = mid + 1;
            }
        }
        return min;
    }
}


// if element just on right of mid is < mid, then mid+1 is smallest element possible
// if element just on left of mid > mid, return mid
// if mid < leftmostvalue, search on left
// if mid > search on right
// Observing, every element's right element is greather than it except for biggest element except for the larget element

// [4, 5, 6, 7, 0, 1, 2]
// Rotation at index 4. Min = 0

// [7, 0, 1, 2, 3, 4, 5, 6]
// Rotation at index 1. Min = 0

// [2, 3, 4, 5, 6, 7, 1]
// Rotation at last index. Min = 1

// [1, 2, 3, 4, 5]
// Rotated 0 times. Already sorted. Min = 1

// [5, 6, 1, 2, 3, 4]
// Rotation at index 2. Min = 1