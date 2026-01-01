class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                if (target >= matrix[i][0] && target <= matrix[i][matrix[i].length-1]) {
                    if (bs(matrix[i], target) != -1)return true;
                } else {
                    break;
                }
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