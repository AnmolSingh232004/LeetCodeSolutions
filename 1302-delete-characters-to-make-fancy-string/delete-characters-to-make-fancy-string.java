class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<s.length(); i++) {
            if (i != 0 && i != s.length()-1 && s.charAt(i) == s.charAt(i-1) && s.charAt(i) == s.charAt(i+1)) {
                continue;
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}