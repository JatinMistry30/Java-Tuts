public class SudokuGame {

    // Check if placing number is safe
    public boolean isSafe(char[][] board, int row, int col, int number) {

        char num = (char) (number + '0');

        // Row & Column check
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) return false;
            if (board[row][i] == num) return false;
        }

        // 3x3 Grid check
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;

        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }

        return true;
    }

    // Backtracking helper
    public boolean helper(char[][] board, int row, int col) {

        // If reached end, solution found
        if (row == 9) {
            return true;
        }

        int nrow, ncol;
        if (col != 8) {
            nrow = row;
            ncol = col + 1;
        } else {
            nrow = row + 1;
            ncol = 0;
        }

        // If already filled, move to next cell
        if (board[row][col] != '.') {
            return helper(board, nrow, ncol);
        }

        // Try digits 1 to 9
        for (int i = 1; i <= 9; i++) {
            if (isSafe(board, row, col, i)) {
                board[row][col] = (char) (i + '0');
                if (helper(board, nrow, ncol)) {
                    return true;
                }
                board[row][col] = '.'; // backtrack
            }
        }

        return false;
    }

    public void solveSudoku(char[][] board) {
        helper(board, 0, 0);
    }

    // Print board
    public static void printBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        SudokuGame game = new SudokuGame();

        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println("Before Solving:");
        printBoard(board);

        game.solveSudoku(board);

        System.out.println("\nAfter Solving:");
        printBoard(board);
    }
}
