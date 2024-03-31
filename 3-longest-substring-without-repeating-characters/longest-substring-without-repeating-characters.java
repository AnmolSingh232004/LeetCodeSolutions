class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)return 0;
        
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0, res = 0;
        while (start < s.length() && end < s.length()) {
            map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);
            while (map.get(s.charAt(end)) > 1) {
                map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                start++;
            }
            res = Math.max(res, end-start+1);
            end++;
        }
        return res;
    }
}