class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || s.length() < t.length())return "";
        int[] tFreq = new int[128];
        int[] sFreq = new int[128];

        for (int i=0; i<t.length(); i++) {
            tFreq[t.charAt(i)]++;
        }

        for (int i=0; i<t.length(); i++) {
            sFreq[s.charAt(i)]++;
        }

        if (isEqual(sFreq, tFreq)) {
            if (s.length() == t.length())return s;
        }

        int lo = 0;
        int hi = t.length();

        String res = "";

        while (hi < s.length() && hi >= lo) {
            if (!isEqual(sFreq, tFreq)) {
                sFreq[s.charAt(hi)]++;
                hi++;
            }

            while (isEqual(sFreq, tFreq)) {
                if (res.equals("") || res.length() > s.substring(lo, hi).length() )res = s.substring(lo, hi);

                sFreq[s.charAt(lo)]--;
                lo++;
            }
        }
        return res;
    }

    public boolean isEqual(int[] sFreq, int[] tFreq) {
        for (int i=0; i<sFreq.length; i++) {
            if (tFreq[i] != 0 && sFreq[i] < tFreq[i])return false;
        }
        return true;
    }

}

// we can store frequencies and just compare them
// initally lets make an int[128] because we have small and capital both letters, a-z, A-Z all represnet some number in 128, a -> 97, A -> 65
// we can create 2 of these for t it will stay constant , for s it will vary based on our dynamic sliding window
// we initalie freq for t then never change it
// we initalize and inital freq for s which will be of size t
// if freq doesnt match we expand window if freq matches we shrink until invalid

// the tricky part is matching