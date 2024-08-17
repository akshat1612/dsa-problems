package graphs;

public class LC200_No_of_islands {

    public static void main(String[] args) {
        char[][] map = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(numIslands(map));
    }

    static int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    count++;
                    bfs(i, j, visited, grid);
                }
            }
        }
        return count;
    }

    static void bfs(int row, int col, boolean[][] visited, char[][] grid) {
        visited[row][col] = true;
        if (row > 0 && !visited[row - 1][col] && grid[row - 1][col] == '1') {
            bfs(row - 1, col, visited, grid);
        }
        if (row < grid.length - 1 && !visited[row + 1][col] && grid[row + 1][col] == '1') {
            bfs(row + 1, col, visited, grid);
        }
        if (col > 0 && !visited[row][col - 1] && grid[row][col - 1] == '1') {
            bfs(row, col - 1, visited, grid);
        }
        if (col < grid[0].length - 1 && !visited[row][col + 1] && grid[row][col + 1] == '1') {
            bfs(row, col + 1, visited, grid);
        }
    }
}
