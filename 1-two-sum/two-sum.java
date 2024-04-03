class Solution {
    public int[] twoSum(int[] nums, int target) {
        // nums[i] + nums[j] = target
        // target - nums[j] = nums[i]
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i=0; i<nums.length; i++) {
            if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i)return new int[]{i, map.get(target - nums[i])};
        }
        return new int[]{69, 69};
    }
}