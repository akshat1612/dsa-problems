package backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC51_N_Queens {
    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
        System.out.println(solveNQueens(5));
    }

    static List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];
        int[] arr= new int[2*n - 1];
        int[] arr2= new int[2*n - 1];
        int[] rowCount = new int[n];
        int[] colCount = new int[n];
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> finalAns = new ArrayList<>();
        solve(0, board, finalAns, arr, arr2, rowCount, colCount);
        return finalAns;
    }

    static void solve(int col, char[][] board, List<List<String>> answer, int[] arr, int[] arr2, int[] rowCount, int[] colCount) {
        if(col == board.length) {
            answer.add(constructBoard(board));
            return;
        }

        for(int i = 0; i < board.length; i++) {
            if(canPlace(i, col, board, arr, arr2, rowCount, colCount)) {
                arr[i+col]++;
                arr2[board.length-1+i-col]++;
                rowCount[i]++;
                colCount[col]++;
                board[i][col] = 'Q';
                solve(col+1, board, answer, arr, arr2, rowCount, colCount);
                board[i][col] = '.';
                arr[i+col]--;
                arr2[board.length-1+i-col]--;
                rowCount[i]--;
                colCount[col]--;
            }
        }
    }

    static List<String> constructBoard(char[][] board) {
        List<String> t = new ArrayList<>();
        for (char[] chars : board) {
            t.add(new String(chars));
        }
        return t;
    }
    static boolean canPlace(int row, int col, char[][] board, int[] arr, int[] arr2, int[] rowCount, int[] colCount) {
        if(arr[row+col] >= 1) {
            return false;
        }
        if(arr2[board.length - 1 + row-col] >= 1) {
            return false;
        }
        if(rowCount[row] >= 1) {
            return false;
        }
        return colCount[col] < 1;
    }
}
