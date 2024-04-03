class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if (map.containsKey(nums[i]) && map.get(nums[i]) >= 1)return true;
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return false;
    }
}