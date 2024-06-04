class Solution {
    public int longestPalindrome(String s) {
        if (s.length() == 1)return 1;
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            if (map.get(s.charAt(i)) == 2) {
                res += 2;
                map.put(s.charAt(i), 0);
            }
        }
        for (Character c : map.keySet()) {
            if (map.get(c) == 1)return res+1;
        }
        return res;
    }
}