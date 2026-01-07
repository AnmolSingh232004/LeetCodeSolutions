class Solution {
    public int characterReplacement(String s, int k) {
        
        int res = 0;

        for (Character currChar = 'A'; currChar<='Z'; currChar++) {
            int lo = 0;
            int hi = 0;
            int wrongCount = 0;

            while (hi < s.length()) {

                if (currChar == s.charAt(hi)) { // normal case if char repeats
                    hi++;
                } else if (currChar != s.charAt(hi) && wrongCount <= k) { // <= k because it needs to break then fix later
                    hi++;
                    wrongCount++;
                }

                while (wrongCount > k && lo <= hi) {
                    if (s.charAt(lo) != currChar)wrongCount--;

                    lo++;
                }

                int winSize = hi - lo;

                res = Math.max(winSize, res);
            }
        }
        return res;
    }
}