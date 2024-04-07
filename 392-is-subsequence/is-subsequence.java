class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0)return true;
        if (t.length() == 0)return false;
        if (s.length() > t.length())return false;
        if (s.length() == t.length() && s.equals(t))return true;

        int sp = 0;
        int tp = 0;
        while (tp < t.length() && sp < s.length()) {
            if (s.charAt(sp) == t.charAt(tp)) {
                sp++;
                tp++;
            } else {
                tp++;
            }
        }
        return sp == s.length();
    }
}