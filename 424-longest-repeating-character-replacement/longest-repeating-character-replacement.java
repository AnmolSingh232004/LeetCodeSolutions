class Solution {
    public int characterReplacement(String s, int k) {

        int maxRes = 0;

        for (char currChar = 'A'; currChar <= 'Z'; currChar++) {

            int lo = 0;
            int wrongCount = 0;

            for (int hi = 0; hi < s.length(); hi++) {

                // 1️⃣ include hi
                if (s.charAt(hi) != currChar) {
                    wrongCount++;
                }

                // 2️⃣ fix window
                while (wrongCount > k) {
                    if (s.charAt(lo) != currChar) {
                        wrongCount--;
                    }
                    lo++;
                }

                // 3️⃣ compute window AFTER fixing
                int resWinSize = hi - lo + 1;
                maxRes = Math.max(maxRes, resWinSize);
            }
        }
        return maxRes;
    }
}
