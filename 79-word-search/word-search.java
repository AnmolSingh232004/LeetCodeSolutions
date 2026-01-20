class Solution {
    boolean res = false;
    public boolean exist(char[][] board, String word) {
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    dfs(board,i, j, word, 0);
                    if (res)return true;
                }
            }
        }
        return res;
    }

    // ["C","A","A"],
    // ["A","A","A"],
    // ["B","C","D"]
    // "AAB"

    public void dfs(char[][] board, int i, int j, String word, int k) {
        if (res)return;
        if (k == word.length()) {
            res = true;
            return;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length)return; 
        if (board[i][j] != word.charAt(k)) {
            return;
        }
        char temp = board[i][j];
        if (board[i][j] == word.charAt(k)) {
            k = k+1;
            board[i][j] = '?';
        }
        

        dfs(board, i, j+1, word, k);
        dfs(board, i, j-1, word, k);
        dfs(board, i+1, j, word, k);
        dfs(board, i-1, j, word, k);

        board[i][j] = temp;
        

    }
}

// first to simplify code