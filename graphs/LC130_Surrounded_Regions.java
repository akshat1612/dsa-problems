package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class LC130_Surrounded_Regions {

    public static void main(String[] args) {
        char[][] adjacency = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        Solution solution = new Solution();
        ArrayUtils.printMatrix(adjacency);
        System.out.println();
        System.out.println("Answer -- ");
        solution.solve(adjacency);
        ArrayUtils.printMatrix(adjacency);
    }

    private static class DS {
        int r, c;
        DS(int row, int col) {
            this.r = row;
            this.c = col;
        }
    }

    private static class Solution {
        public void solve(char[][] board) {
            int rows = board.length;
            int cols = board[0].length;
            boolean[][] visited = new boolean[rows][cols];
            char[][] ans = new char[rows][cols];
            Queue<DS> q = new LinkedList<>();
            for(int i = 0 ; i < cols; i++) {
                if(board[0][i] == 'O') {
                    ans[0][i] = 'O';
                    q.add(new DS(0,i));
                }
                if(board[rows-1][i] == 'O') {
                    ans[rows-1][i] = 'O';
                    q.add(new DS(rows-1,i));
                }
                visited[0][i] = true;
                visited[rows-1][i] = true;
            }
            for(int i = 0 ; i < rows; i++) {
                if(board[i][0] == 'O' && !visited[i][0]) {
                    ans[i][0] = 'O';
                    q.add(new DS(i,0));
                }
                if(board[i][cols-1] == 'O' && !visited[i][cols-1]) {
                    ans[i][cols-1] = 'O';
                    q.add(new DS(i, cols-1));
                }
                visited[i][0] = true;
                visited[i][cols-1] = true;
            }
            int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            while(!q.isEmpty()) {
                DS temp = q.poll();
                for(int i = 0 ; i < 4; i++) {
                    int nr = temp.r + dir[i][0];
                    int nc = temp.c + dir[i][1];
                    if(nr == -1 || nc == -1 || nr == rows || nc == cols || visited[nr][nc] || board[nr][nc] == 'X') {
                        continue;
                    } else {
                        q.add(new DS(nr,nc));
                        ans[nr][nc] = 'O';
                    }
                    visited[nr][nc] = true;
                }
            }

            for(int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if(ans[i][j] != 'O'){
                        board[i][j] = 'X';
                    }
                }
            }
        }
    }
}