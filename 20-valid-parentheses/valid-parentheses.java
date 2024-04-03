class Solution {
    public boolean isValid(String s) {
        if (s.length() < 2)return false;
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            char cc = s.charAt(i);
            if (cc == '(' || cc == '{' || cc == '[') {
                stack.push(cc);
            } else if(cc == ')') {
                if (stack.size() > 0 && stack.peek() == '(')stack.pop();
                else return false;
            } else if(cc == '}') {
                if (stack.size() > 0 && stack.peek() == '{')stack.pop();
                else return false;
            } else if(cc == ']') {
                if (stack.size() > 0 && stack.peek() == '[')stack.pop();
                else return false;
            }
        }
        return stack.isEmpty();
    }
}