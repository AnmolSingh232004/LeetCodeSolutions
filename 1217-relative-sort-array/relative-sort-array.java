class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<arr1.length; i++) {
            map.put(arr1[i], map.getOrDefault(arr1[i], 0) + 1);
        }
        int[] res = new int[arr1.length];

        int j = 0;
        int i = 0;

        while (i < res.length && j < arr2.length) {
            while (map.get(arr2[j]) >= 1) {
                res[i] = arr2[j];
                i++;
                map.put(arr2[j], map.get(arr2[j]) - 1);
            }
            j++;
        }
        Arrays.sort(arr1);
        for (int p=0; p<arr1.length; p++) {
            while (map.get(arr1[p]) >= 1) {
                res[i] = arr1[p];
                map.put(arr1[p], map.get(arr1[p]) - 1);
                i++;
            }
        }

        return res;
    }
}