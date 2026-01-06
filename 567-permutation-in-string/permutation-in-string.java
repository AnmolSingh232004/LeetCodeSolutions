class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())return false;
        
        int[] need = new int[26];
        int[] window = new int[26];

        for (int i=0; i<s1.length(); i++) { // populate need window this is our comparison for perfect permutation
            need[Math.abs(s1.charAt(i)) - 'a']++;
        }

        for (int i=0; i<s1.length(); i++) { // populate inditial fixed window
            window[Math.abs(s2.charAt(i) - 'a')]++;
        }

        if (Arrays.equals(need, window))return true;

        int lo = 0;
        int hi = s1.length() - 1;

        hi++;

        while (hi < s2.length()) {
            int charIndexHi = Math.abs( 'a' - s2.charAt(hi) );
            int charIndexLo = Math.abs( 'a' - s2.charAt(lo) );
            window[charIndexHi]++;
            window[charIndexLo]--;
            hi++;
            lo++;

            if (Arrays.equals(need, window))return true;
        }

        return false;
    }
}