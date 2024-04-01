class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i=0; i<nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for (int i=0; i<nums2.length; i++) {
            set2.add(nums2[i]);
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Set<Integer> setT = new HashSet<>();
        for (int i=0; i<nums1.length; i++) {
            if (set2.contains(nums1[i]) || setT.contains(nums1[i]))continue;
            temp.add(nums1[i]);
            setT.add(nums1[i]);
        }
        res.add(temp);
        temp = new ArrayList<>();
        setT = new HashSet<>();
        for (int i=0; i<nums2.length; i++) {
            if (set1.contains(nums2[i]) || setT.contains(nums2[i]))continue;
            temp.add(nums2[i]);
            setT.add(nums2[i]);
        }
        res.add(temp);
        temp = new ArrayList<>();
        return res;
    }
}