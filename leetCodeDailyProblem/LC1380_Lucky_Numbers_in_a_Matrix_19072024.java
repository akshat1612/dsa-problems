package leetCodeDailyProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n matrix of distinct numbers, return all lucky numbers in the matrix in any order.
 * <p>
 * A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.
 */
public class LC1380_Lucky_Numbers_in_a_Matrix_19072024 {
    public static void main(String[] args) {
        int[][] matrix = {{3, 7, 8}, {9, 11, 13}, {15, 16, 17}};
        System.out.println(luckyNumbers(matrix));

        matrix = new int[][]{{1, 10, 4, 2}, {9, 3, 8, 7}, {15, 16, 17, 12}};
        System.out.println(luckyNumbers(matrix));

        matrix = new int[][]{{7, 8}, {1, 2}};
        System.out.println(luckyNumbers(matrix));
    }

    public static List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            int col = findMinCol(matrix, i);
            if (checkIfColIsMax(matrix, col, i)) {
                ans.add(matrix[i][col]);
            }
        }
        return ans;
    }

    public static int findMinCol(int[][] matrix, int rowNum) {
        int min = 100001;
        int col = -1;
        for (int i = 0; i < matrix[rowNum].length; i++) {
            if (matrix[rowNum][i] < min) {
                min = matrix[rowNum][i];
                col = i;
            }
        }
        return col;
    }

    public static boolean checkIfColIsMax(int[][] matrix, int colNum, int rowNum) {
        int max = 0;
        for (int[] ints : matrix) {
            if (ints[colNum] > max) {
                max = Math.max(ints[colNum], max);
            }
        }
        return (max == matrix[rowNum][colNum]);
    }
}
