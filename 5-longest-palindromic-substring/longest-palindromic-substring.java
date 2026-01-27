class Solution {
    public String longestPalindrome(String s) {
        int lo = 0;
        int hi =0;
        String res = "";
        Map<int[], String> map = new HashMap<>();

        while (lo < s.length() && hi < s.length()) {
            if ( isPalin(s, lo, hi) ) {
                if (map.containsKey(new int[]{lo, hi}) && res.length() < map.get(new int[]{lo, hi}).length() )res = s.substring(lo, hi+1);

                else if (s.substring(lo, hi+1).length() > res.length()) {
                res = s.substring(lo, hi+1);
                map.put(new int[]{lo, hi}, res);
                }

            }
            if (hi == s.length() - 1) {
                lo++;
                hi = lo;
            }
            hi++;

            
        }
        return res;
    }

    public boolean isPalin(String s, int lo, int hi) {
        while (lo <= hi) {
            if (s.charAt(lo) != s.charAt(hi))return false;
            hi--;
            lo++;
        }
        return true;
    }
}