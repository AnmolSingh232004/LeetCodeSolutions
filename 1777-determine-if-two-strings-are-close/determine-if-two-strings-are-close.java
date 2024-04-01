class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length())return false;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        int max1 = 0;
        int max2 = 0;
        for (int i=0; i<word1.length(); i++) {
            map1.put(word1.charAt(i), map1.getOrDefault(word1.charAt(i), 0) + 1);
            map2.put(word2.charAt(i), map2.getOrDefault(word2.charAt(i), 0) + 1);
            max1 = Math.max(max1, map1.get(word1.charAt(i)));
            max2 = Math.max(max2, map2.get(word2.charAt(i)));
        }
        for (int i=0; i<word2.length(); i++) {
            if (!map1.containsKey(word2.charAt(i)) || !map2.containsKey(word1.charAt(i)))
            return false;
        }

        if (max1 != max2)return false;

        Map<Integer, Integer> map3 = new HashMap<>();
        for (Character c : map1.keySet()) {
            int map1Freq = map1.get(c);
            map3.put(map1Freq, map3.getOrDefault(map1Freq, 0) + 1);
        }
        for (Character c : map2.keySet()) {
            int map2Freq = map2.get(c);
            map3.put(map2Freq, map3.getOrDefault(map2Freq, 0) - 1);
        }
        for (Integer i : map3.keySet()) {
            if (map3.get(i) != 0)return false;
        }


        return true;
    }
}