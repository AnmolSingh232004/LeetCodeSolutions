class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i=0; i<arr.length; i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for (Integer i : freq.keySet()) {
            if (set.contains(freq.get(i)))return false;
            set.add(freq.get(i));
        }
        return true;
    }
}