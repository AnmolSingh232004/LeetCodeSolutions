class Solution {
    public int characterReplacement(String s, int k) {

        List<Character> alpha = new ArrayList<>(); //A,B,C,D,E
        for (char c ='A'; c<='Z'; c++) {
            alpha.add(c);
        }

        int maxRes = 0;

        for (int i=0; i<alpha.size(); i++) { // s = "ABAB", k = 2
            int lo = 0;
            int hi = 0;
            int wrongCount = 0;
            Character currChar = alpha.get(i);

        while (hi < s.length()) { // Input: s = "AABABBA", k = 1
            if (s.charAt(hi) == currChar) { // same char
            hi++;
            }
            else if (s.charAt(hi) != currChar && wrongCount <= k) { // not same char but we have chances
            wrongCount++;
            hi++;
            } 

            while (wrongCount > k && lo < hi) {
                if (s.charAt(lo) != currChar) {
                    wrongCount--;
                    lo++;
                } else {
                lo++;
                }
            }
            int restWinSize = hi - lo;
            maxRes = Math.max(maxRes, restWinSize);
            } 
        }
        return maxRes;
        }
       
    }

// window is valid until -> winSize - wrongCount >= winSize
// 3 condns
// char is same as in set
// char is not same but we have chances
// char is not same and we dont have chances