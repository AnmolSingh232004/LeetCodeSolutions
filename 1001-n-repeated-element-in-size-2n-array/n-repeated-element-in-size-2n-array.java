class Solution {
    public int repeatedNTimes(int[] nums) {
        int count = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) == count)return nums[i];
        }

        return -1;
    }
}

// nums.length = 2*n
// nums.length / 2 = n