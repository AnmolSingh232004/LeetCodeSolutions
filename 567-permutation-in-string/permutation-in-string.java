class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())return false;
        int[] need = new int[26]; // freq of s1
        int[] window = new int[26]; // freq of window

        for (int i=0; i<s1.length(); i++) { // populate need window using s1
            need[Math.abs(s1.charAt(i)) - 'a']++;
        }

        for (int i=0; i<s1.length(); i++) { // populate initial fixed window
            window[Math.abs(s2.charAt(i) - 'a')]++;
        }

        if (Arrays.equals(need, window))return true; // if arrays are equal intially 

        int lo = 0;
        int hi = s1.length() - 1;

        hi++; // make hi start from outside the window

        while (hi < s2.length()) {
            int charIndexHi = Math.abs( 'a' - s2.charAt(hi) ); // char just after window head
            int charIndexLo = Math.abs( 'a' - s2.charAt(lo) ); // chat at window tail
            window[charIndexHi]++;
            window[charIndexLo]--;
            hi++;
            lo++;

            if (Arrays.equals(need, window))return true;
        }

        return false;
    }
}