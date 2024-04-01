class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '*') {
                stack.pop();
                continue;
            }
            stack.push(s.charAt(i));
        }
        char[] toInt = new char[stack.size()];
        for (int i=toInt.length-1; i>=0; i--) {
            toInt[i] = stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<toInt.length; i++) {
            sb.append(toInt[i]);
        }
        return sb.toString();
    }
}