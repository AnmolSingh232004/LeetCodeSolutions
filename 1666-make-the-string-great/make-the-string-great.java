class Solution {
    public String makeGood(String s) {
        if (s.length() == 1)return s;

        Stack<Character> stack = new Stack<>();

        for (int i=0; i<s.length(); i++) {
            if (!stack.isEmpty() && ((s.charAt(i) != stack.peek()) &&
            (s.charAt(i) == Character.toLowerCase(stack.peek()) ||
            s.charAt(i) == Character.toUpperCase(stack.peek())))) {

            if (!stack.isEmpty())stack.pop();
            
            } else {
            stack.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
}
}