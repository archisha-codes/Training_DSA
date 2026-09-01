class Solution {

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {

        // Find an empty cell
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                if (board[row][col] == '.') {

                    // Try digits 1 to 9
                    for (char num = '1'; num <= '9'; num++) {

                        if (isValid(board, row, col, num)) {

                            // Choose
                            board[row][col] = num;

                            // Explore
                            if (solve(board)) {
                                return true;
                            }

                            // Undo / Backtrack
                            board[row][col] = '.';
                        }
                    }

                    // No number works here
                    return false;
                }
            }
        }

        // No empty cells → Sudoku solved
        return true;
    }

    private boolean isValid(char[][] board,
                            int row,
                            int col,
                            char num) {

        // Check row
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == num) {
                return false;
            }
        }

        // Check column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        // Find top-left corner of 3x3 box
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        // Check 3x3 box
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}