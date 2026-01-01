class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {


        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                int res = bs(matrix[i], target);
                if (res != -1)return true;
            }
        }
        return false;
    }

    public int bs(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length-1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] < target) {
                lo = mid + 1; 
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}