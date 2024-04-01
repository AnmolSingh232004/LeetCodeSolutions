class Solution {
    public boolean closeStrings(String word1, String word2) {
        // store word1 into map1 with its freq
        // store word2 into map2 with its freq
        if (word1.length() != word2.length())return false;

        int[] map1 = new int[27];
        int[] map2 = new int[27];
        Set<Character> set = new HashSet<>();
        for (int i=0; i<word1.length(); i++) {
            map1[word1.charAt(i) - 'a']++;
            map2[word2.charAt(i) - 'a']++;
            set.add(word1.charAt(i));
        }
        for (int i=0; i<word2.length(); i++) {
            if (set.contains(word2.charAt(i)))set.remove(word2.charAt(i));
        }
        if (!set.isEmpty())return false;
        // checks if both atleast have same letters 
        Arrays.sort(map1);
        Arrays.sort(map2);
        for (int i=0; i<map1.length; i++) {
            if (map1[i] != map2[i])return false;
        }

        return true;
    }
}