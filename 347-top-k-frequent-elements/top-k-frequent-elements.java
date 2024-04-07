class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int[] res = new int[k];
        for (int i=0; i<nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        int[] freqfreq = new int[freq.size()];
        int it = 0;
        for (Integer i : freq.keySet()) {
            freqfreq[it] = freq.get(i);
            it++;
        }
        it = 0;
        Arrays.sort(freqfreq);
        for (int i=freqfreq.length-1; i>=0; i--) {
            for (Integer n : freq.keySet()) {
                if (freqfreq[i] == freq.get(n)) {
                    if (it >= k)break;
                    res[it] = n;
                    freq.put(n, -1);
                    it++;
                }
            }
        }
        return res;
}
}