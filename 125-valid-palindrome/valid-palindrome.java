class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 1)return true;
        int start = 0;
        int end = s.length()-1;
        String t = s.toLowerCase();
        while (start < end) {
            while(!Character.isLetterOrDigit((t.charAt(start)))) {
                if (start < end)start++;
                else break;
            }
            while(!Character.isLetterOrDigit(t.charAt(end))) {
                if (start < end)end--;
                else break;
            }
            if (t.charAt(start) != t.charAt(end))return false;
            start++;
            end--;
        }
        return true;
    }
}