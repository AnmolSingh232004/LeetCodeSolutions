class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length())return false;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        int max1 = 0;
        int max2 = 0;
        int min1 = 0;
        int min2 = 0;
        for (int i=0; i<word1.length(); i++) {
            map1.put(word1.charAt(i), map1.getOrDefault(word1.charAt(i), 0) + 1);
            map2.put(word2.charAt(i), map2.getOrDefault(word2.charAt(i), 0) + 1);
            max1 = Math.max(max1, map1.get(word1.charAt(i)));
            max2 = Math.max(max2, map2.get(word2.charAt(i)));
            min1 = Math.max(min1, map1.get(word1.charAt(i)));
            min2 = Math.max(min2, map2.get(word2.charAt(i)));
        }
        for (int i=0; i<word2.length(); i++) {
            if (!map1.containsKey(word2.charAt(i)) || !map2.containsKey(word1.charAt(i)))
            return false;
        }

        if (max1 != max2 || min1 != min2)return false;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (Character c : map1.keySet()) {
            list1.add(map1.get(c));
        }
        for (Character c : map2.keySet()) {
            list2.add(map2.get(c));
        }
        Collections.sort(list1);
        Collections.sort(list2);
        if (!list1.equals(list2))return false;

        return true;
    }
}