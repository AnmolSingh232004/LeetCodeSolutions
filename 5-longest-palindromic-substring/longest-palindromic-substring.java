class Solution {
    public String longestPalindrome(String s) {

        String res = s.substring(0,1);

        for (int i=0; i<s.length(); i++) {

            int j = i-1;
            int k = i+1;

            while (j >= 0 && k <= s.length()-1) { // assuming center is odd
                if (s.charAt(j) == s.charAt(k)) {
                    if (res.length() < k-j+1) {
                        res = s.substring(j, k+1);
                    }
                    k++;
                    j--;
                } else {
                    break;
                }
            }

            j = i;
            k = i+1;
            while (j >= 0 && k <= s.length()-1) { // assuming center is even
                if (s.charAt(j) == s.charAt(k)) {
                    if (res.length() < k-j+1) {
                        res = s.substring(j, k+1);
                    }
                    k++;
                    j--;
                } else {
                    break;
                }
            }

        }
        return res;
    }
}

// go through every element in the string and compare it to its left and right element if they are equal its valid and keep expanding otherwise its not and store using greedy