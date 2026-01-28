class Solution {
    public int countSubstrings(String s) {
        int res = 0;

        for (int i=0; i<s.length(); i++) {
            int lo = i;
            int hi = i;
            // boolean isOdd = false;

            while (hi < s.length()) {
                // isOdd = true;
                if (lo >= 0 && hi < s.length() && s.charAt(hi) == s.charAt(lo)) {
                    res++;
                    hi++;
                    lo--;
                }
                else {break;}
            }

            lo = i;
            hi = i+1;

            while (hi < s.length()) {
                if (lo >= 0 && hi < s.length() && s.charAt(hi) == s.charAt(lo)) {
                    res++;
                    hi++;
                    lo--;
                }
                else{break;}
            }
        }
        return res;
    }
}

// Two pointer approach considering every center to be a valid, palindrome and expanding upon it, this helps by determining if its a valid palindrome while expanding search space itself