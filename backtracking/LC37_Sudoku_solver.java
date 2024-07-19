package backtracking;

public class LC37_Sudoku_solver {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        printSudoku(board);
        solve(board);
        System.out.println();
        System.out.println();
        printSudoku(board);
    }

    static boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char a = '1'; a <= '9'; a++) {
                        if (canPlace(board, i, j, a)) {
                            board[i][j] = a;
                            if (solve(board)) {
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    static boolean canPlace(char[][] board, int i, int j, char a) {
        int l = 3 * (i / 3);
        int m = 3 * (j / 3);
        for (int num = 0; num < 9; num++) {
            if (board[i][num] == a) {
                return false;
            }
            if (board[num][j] == a) {
                return false;
            }

            if (board[l + (num / 3)][m + (num % 3)] == a) {
                return false;
            }
        }
        return true;
    }

    static void printSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
                if(j %3 == 2) {
                    System.out.print(" ");
                }
            }
            if(i % 3 == 2) {
                System.out.println();
            }
            System.out.println();
        }
    }
}
