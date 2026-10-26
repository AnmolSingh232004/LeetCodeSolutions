class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<s.length(); i++) {

            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else  {
                if (stack.size() > 0 && s.charAt(i) == ')' && stack.peek() == '(')stack.pop();
                else if (stack.size() > 0 && s.charAt(i) == ']' && stack.peek() == '[')stack.pop();
                else if (stack.size() > 0 && s.charAt(i) == '}' && stack.peek() == '{')stack.pop();
                else return false;
        }       
    }
    return stack.isEmpty();
    }
}

// In one itteration, 3 things can happen
// We can push a opening bracket onto stack
// We can pop a valid closing bracket from stack
// A bracket which is not corresponding to the opening bracket is found and we return false