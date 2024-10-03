class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> map = new HashMap<>();

        int k = 1;

        for (int i=0; i<sorted.length; i++) {
            if (!map.containsKey(sorted[i])) {
                map.put(sorted[i], k);
                k++;
            }
        }
        int[] res = new int[arr.length];
        
        for (int i=0; i<arr.length; i++) {
            res[i] = map.get(arr[i]);
        }
        return res;
    }
}