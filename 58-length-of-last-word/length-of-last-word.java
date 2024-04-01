class Solution {
    public int lengthOfLastWord(String s) {
        int end = s.length()-1;
        while (s.charAt(end) == ' ')end--;
        int res = 0;
        for (int i=end; i>=0; i--) {
            if (s.charAt(i) != ' ') {
                res++;
            } else {
                break;
            }
        }
        return res;
    }
}