package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class LC1020_Number_of_enclaves {

    public static void main(String[] args) {
        int[][] grid = {{0, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}};
        Solution solution = new Solution();
        ArrayUtils.printMatrix(grid);
        System.out.println();
        System.out.println(solution.numEnclaves(grid));
    }

    public static class DS {
        int r, c;

        DS(int row, int col) {
            this.r = row;
            this.c = col;
        }
    }

    private static class Solution {
        public int numEnclaves(int[][] grid) {
            int rows = grid.length;
            int cols = grid[0].length;
            int[][] visited = new int[rows][cols];
            Queue<DS> q = new LinkedList<>();
            for (int i = 0; i < rows; i++) {
                if (grid[i][0] == 1) {
                    q.add(new DS(i, 0));
                    visited[i][0] = 1;
                }
                if (grid[i][cols - 1] == 1) {
                    q.add(new DS(i, cols - 1));
                    visited[i][cols - 1] = 1;
                }
            }
            for (int i = 0; i < cols; i++) {
                if (grid[0][i] == 1 && visited[0][i] != 1) {
                    q.add(new DS(0, i));
                    visited[0][i] = 1;
                }
                if (grid[rows - 1][i] == 1 && visited[rows - 1][i] != 1) {
                    q.add(new DS(rows - 1, i));
                    visited[rows - 1][i] = 1;
                }
            }

            int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
            while (!q.isEmpty()) {
                DS temp = q.poll();
                int cr = temp.r;
                int cc = temp.c;
                for (int i = 0; i < 4; i++) {
                    int nr = cr + dirs[i][0];
                    int nc = cc + dirs[i][1];
                    if (nr == -1 || nc == -1 || nr == rows || nc == cols || grid[nr][nc] == 0 || visited[nr][nc] == 1) {
                        continue;
                    }
                    visited[nr][nc] = 1;
                    q.add(new DS(nr, nc));
                }
            }
            int cnt = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (visited[i][j] != grid[i][j]) {
                        cnt++;
                    }
                }
            }
            return cnt;
        }
    }
}
