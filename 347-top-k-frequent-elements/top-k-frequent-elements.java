class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();


        for (int i=0; i<nums.length; i++) {
            if (!map.containsKey(nums[i])) map.put(nums[i], 1);
            else map.put(nums[i], map.get(nums[i]) + 1);
            
        }


        int[] res = new int[k];

        int count = k;

        while (count > 0) {
        int currMax = 0;
        int currMaxValue = 0;
        
        for (Integer x : map.keySet()) {
            if (currMaxValue < map.get(x)) {
                currMax = x;
                currMaxValue = map.get(x);
            }
        }
        res[count-1] = currMax;
        map.remove(currMax);
        count--;

        }
        return res;
        }
    }
    // key is elemnt
    // value is its frequency
