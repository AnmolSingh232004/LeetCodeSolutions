class Solution {
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length-1;

        int mid = lo + (hi - lo) / 2;
        int min = nums[mid];

        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;

            if (mid+1 < nums.length && nums[mid+1] < nums[mid]) { // every element on right of any element has to be greater if sorted
                return nums[mid+1]; // mid+1 < mid means it must be smallest value since it breaks the sorted part and only pivot does it
            } 

            if (mid-1 >= 0 && nums[mid-1] > nums[mid]) { // every element on left must be smaller to curr element
                return nums[mid]; // this again is the pivot so we return mid element since its smaller than just left to it
            }

            if (nums[mid] <= nums[lo]) { // mid can only be smaller than left if there is shifiting there which must mean a bigger value pushed smallest to its right
                min = Math.min(min, nums[lo]); // make sure to check if lo is smallest yet
                hi = mid - 1;
            } else if (nums[mid] > nums[lo]) { // This means either lo is the answer or the answer is in the right side so we check if lo is answer and move to right side
                min = Math.min(min, nums[lo]); // same thing
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