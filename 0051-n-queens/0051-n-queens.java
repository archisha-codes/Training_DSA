class Solution {

    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];

        // Fill board with '.'
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        backtrack(board, 0);

        return result;
    }

    void backtrack(char[][] board, int row) {

        // All queens placed
        if (row == board.length) {
            result.add(createBoard(board));
            return;
        }

        // Try every column in this row
        for (int col = 0; col < board.length; col++) {

            // Check if queen can be placed
            if (!isSafe(board, row, col)) {
                continue;
            }

            // Choose
            board[row][col] = 'Q';

            // Explore
            backtrack(board, row + 1);

            // Undo
            board[row][col] = '.';
        }
    }

    boolean isSafe(char[][] board, int row, int col) {

        int n = board.length;

        // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0;
             i--, j--) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n;
             i--, j++) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    List<String> createBoard(char[][] board) {

        List<String> list = new ArrayList<>();

        for (char[] row : board) {
            list.add(new String(row));
        }

        return list;
    }
}