package graphs;

public class ArrayUtils {

    public static void printMatrix(int[][] matrix) {
        for(int[] i: matrix) {
            for (int j: i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    public static void printMatrix(char[][] matrix) {
        for(char[] i: matrix) {
            for (char j: i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
