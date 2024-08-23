package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class LC542_0_1_Matrix {

    public static void main(String[] args) {
        int[][] adjacency = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        Solution solution = new Solution();
        ArrayUtils.printMatrix(adjacency);
        System.out.println();
        System.out.println("Answer -- ");
        ArrayUtils.printMatrix(solution.updateMatrix(adjacency));
    }

    private static class DS {
        int r, c, dis;

        DS(int row, int col, int dis) {
            this.r = row;
            this.c = col;
            this.dis = dis;
        }
    }

    private static class Solution {
        public int[][] updateMatrix(int[][] mat) {
            int rows = mat.length;
            int cols = mat[0].length;
            int[][] visited = new int[rows][cols];
            Queue<DS> q = new LinkedList<>();


            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (mat[i][j] == 0) {
                        visited[i][j] = 1;
                        q.add(new DS(i, j, 0));
                    }
                }
            }

            int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            while (!q.isEmpty()) {
                DS temp = q.poll();
                for (int i = 0; i < 4; i++) {
                    int r = temp.r + dir[i][0];
                    int c = temp.c + dir[i][1];
                    if (r == -1 || c == -1 || r == rows || c == cols || visited[r][c] != 0) {
                        continue;
                    } else {
                        visited[r][c] = 1;
                        mat[r][c] = temp.dis + 1;
                        q.add(new DS(r, c, (temp.dis + 1)));
                    }
                }
            }
            return mat;

        }

    }
}