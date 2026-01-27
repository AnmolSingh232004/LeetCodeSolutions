class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 1)return s;
        String res = "";
        
        for (int i=0; i<s.length(); i++) {
            int lo = i;
            int hi = i;

            while (lo >= 0 && hi < s.length() && s.charAt(lo) == s.charAt(hi)) {
                if (res.length() < hi - lo + 1) {
                    res = s.substring(lo, hi+1);
                }
                lo--;
                hi++;
            }

            lo = i;
            hi = i+1;
            while (lo >= 0 && hi < s.length() && s.charAt(lo) == s.charAt(hi)) {
                if (res.length() < hi - lo + 1) {
                    res = s.substring(lo, hi+1);
                }
                lo--;
                hi++;
            }

        }
        return res;
    }
}

// How about we start comparing from the middle
// so for babad, we do start our pointers from [1] which is a and exapnd on both side until valid and then adanvce our pointers