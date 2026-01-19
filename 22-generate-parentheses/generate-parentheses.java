class Solution {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(n, 0, 0, new StringBuilder());

        return res;
    }

    public void dfs(int n, int openCount, int closeCount, StringBuilder paren) {
        if (openCount == n && closeCount == n) {
            res.add(new String(paren));
            return;
        }
        
        if (paren.length() > n* 2|| openCount > n || closeCount > n || closeCount > openCount) {
            return;
        }

        paren.append('(');
        dfs(n, openCount + 1, closeCount, paren);
        paren.deleteCharAt(paren.length() - 1);

        paren.append(')');
        dfs(n, openCount, closeCount + 1, paren);
        paren.deleteCharAt(paren.length() - 1);

    }
}

// every call will have option to include ( or )
// if number of ( becomes less than half of array size means bad combo so return
//
