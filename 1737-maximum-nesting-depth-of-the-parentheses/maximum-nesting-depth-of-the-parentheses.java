class Solution {
    public int maxDepth(String s) {
        if (s.length() == 0)return 0;
        Stack<Character> stack = new Stack<>();
        int maxLen = 0;
        for (int i=0; i<s.length(); i++) {

            if (s.charAt(i) == '(') {
            stack.push(s.charAt(i));
            maxLen = Math.max(stack.size(), maxLen);
            }

            if (!stack.isEmpty() && s.charAt(i) == ')') {
                stack.pop();
            }

        }
        return maxLen;
    }
}