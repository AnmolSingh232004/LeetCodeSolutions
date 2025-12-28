class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;

        for (int i=0; i<nums.length; i++) { // fill hashset with nums so no duplicates
            set.add(nums[i]);
        }

        for (int num : set) { // num = element in set
            int localRes = 0;
            int curr = 0;

            if (!set.contains(num - 1)) { // if root element of any subsequence is found we process

            while (set.contains(num + curr)) { // if set contains num + curr (curr = 1+1+1+1) || basically all sucessor of num
            localRes++;
            curr++;
            }
            }
            res = Math.max(res, localRes);
            

        }
        return res;
    }
}