package graphs;

public class LC733_Flood_fill {

    public static void main(String[] args) {
        int[][] adjacency = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        Solution solution = new Solution();
        ArrayUtils.printMatrix(adjacency);
        int[][] ans = solution.floodFill(adjacency, 1, 1, 2);
        System.out.println();
        ArrayUtils.printMatrix(ans);
    }


    private static class Solution {

        int originalColor, rows, cols, newColor;
        int[][] floodFill(int[][] image, int sr, int sc, int color) {
            rows = image.length;
            cols = image[0].length;
            newColor = color;
            originalColor = image[sr][sc];
            if(originalColor != newColor) {
                bfs(image, sr, sc);
            }
            return image;
        }

        void bfs(int[][] image, int currRow, int currCol) {
            if(currRow < 0 || currCol < 0 || currRow >= rows || currCol >= cols || (image[currRow][currCol] != originalColor)) {
                return;
            }
            image[currRow][currCol] = newColor;
            bfs(image, currRow - 1, currCol);
            bfs(image, currRow + 1, currCol);
            bfs(image, currRow, currCol + 1);
            bfs(image, currRow, currCol - 1);
        }
    }
}
