class Solution {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(n, 0, 0, new StringBuilder());
        return res;    
    }

    public void dfs(int n, int openCount, int closeCount, StringBuilder sb) {
        if (openCount == n && closeCount == n) {
            res.add(new String(sb));
            return;
        }
       
        if (closeCount > openCount || openCount > n || closeCount > n)return;

        sb.append('(');
        dfs(n, openCount + 1, closeCount, sb);
        sb.deleteCharAt(sb.length() - 1);

        sb.append(')');
        dfs(n, openCount, closeCount + 1, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}