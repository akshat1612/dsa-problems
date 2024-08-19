package graphs;

import java.util.LinkedList;
import java.util.Queue;
public class LC994_Rotten_oranges {

    public static void main(String[] args) {
        int[][] adjacency = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        Solution solution = new Solution();
        ArrayUtils.printMatrix(adjacency);
        System.out.println();
        System.out.println("Answer -- " + solution.orangesRotting(adjacency));
    }
    private static class DS {
        int row, col, time;

        DS(int r, int c, int t) {
            this.row = r;
            this.col = c;
            this.time = t;
        }
    }
    private static class Solution {

        int rows, cols;
        int[][] directions = { {0,-1}, {0, 1}, {-1, 0}, {1, 0}};
        public int orangesRotting(int[][] grid) {
            rows = grid.length;
            cols = grid[0].length;
            int c = 0;
            int ans = 0;
            Queue<DS> q = new LinkedList<>();
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if(grid[i][j] == 2) {
                        q.add(new DS(i, j, 0));
                    }
                    if(grid[i][j] != 0) {
                        c++;
                    }
                }
            }
            while(!q.isEmpty()) {
                c--;
                DS temp = q.poll();
                ans = Math.max(ans, temp.time);
                for(int[] a: directions) {
                    bfs(temp.row + a[0], temp.col + a[1], temp.time, q, grid);
                }
            }
            if(c != 0) {
                return -1;
            }
            return ans;
        }

        void bfs(int sr, int sc, int time, Queue<DS> q, int[][] grid) {
            if(sr < 0 || sc < 0 || sr >= rows || sc >= cols || grid[sr][sc] != 1) {
                return;
            }
            grid[sr][sc] = 2;
            q.add(new DS(sr, sc, time + 1));
        }

    }
}
