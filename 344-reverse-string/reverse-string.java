class Solution {
    public void reverseString(char[] s) {
        int end = s.length-1;
        for (int i=0; i<s.length; i++) {
            if (i > end)break;
           char temp = s[i];
           s[i] = s[end];
           s[end] = temp;
           end--;
        }
    }
}