class Solution {
    public String longestPalindrome(String s) {
        int lo = 0;
        int hi =0;
        String res = "";

        while (lo < s.length() && hi < s.length()) {
            if ( isPalin(s, lo, hi) ) {
                if (s.substring(lo, hi+1).length() > res.length())res = s.substring(lo, hi+1);
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