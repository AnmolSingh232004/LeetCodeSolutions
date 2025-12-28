class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i=0; i<9; i++) { // checks all rows for any duplicates
            Set<Character> seenRow = new HashSet<>();
            for (int j=0; j<9; j++) {
                if (board[i][j] == '.')continue; // if empty skip
                if (seenRow.contains(board[i][j]))return false; // if duplicate found return false
                seenRow.add(board[i][j]); // add if doesnt exist
            }
        }

            for (int i=0; i<9; i++) {
            Set<Character> seenCol = new HashSet<>(); // same thing but for col
            for (int j=0; j<9; j++) {
                if (board[j][i] == '.')continue;
                if (seenCol.contains(board[j][i]))return false;
                seenCol.add(board[j][i]);
            }
        }

        for (int box = 0; box < 9; box ++) { // for each square traversal
        Set<Character> seenBox = new HashSet<>();
        for (int rOffset = 0; rOffset<3; rOffset++) { // determines movment inside sub grid of board 
            for (int cOffset=0; cOffset<3; cOffset++) { // same 
                int row = (box / 3) * 3 + rOffset; // final calculated index
                int col = (box % 3) * 3 + cOffset; // final calculated index

                if (board[row][col] == '.')continue; // same drill for checking
                if (seenBox.contains(board[row][col]))return false;
                seenBox.add(board[row][col]);
            }
        }
        }

        return true;

    }
}