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
        List<Integer> list = new ArrayList<>();
        for (Integer s : map.keySet()) {
            while (map.get(s) >= 1) {
            list.add(s);
            map.put(s, map.get(s) - 1);
            }
        }
        Collections.sort(list);

        int k = 0;
        for (int p=i; p<res.length; p++) {
            res[p] = list.get(k);
            k++;
        }

        return res;
    }
}