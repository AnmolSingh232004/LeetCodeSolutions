class Solution {
    public int bs(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;

        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int[] twoSum(int[] numbers, int target) {
        for (int i=0; i<numbers.length; i++) {
            int localTar = target - numbers[i];
            int ind = bs(numbers, localTar);
            if (ind != -1 && ind != i) {
                int small = Math.min(i, ind);
                int large = Math.max(i, ind);
                if (numbers[i] + numbers[ind] == target)return new int[]{small+1, large+1};
            }
        }
        return new int[]{0};
    }
}

