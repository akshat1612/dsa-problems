package backtracking;

import java.util.Arrays;

public class GFG_M_Coloring_graph {
    public static void main(String[] args) {
        int n = 4;
        int m = 3;
        boolean[][] graph = new boolean[n][n];
        int[][] paths = {{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 3}};
        for (int[] path : paths) {
            graph[path[0] - 1][path[1] - 1] = true;
            graph[path[1] - 1][path[0] - 1] = true;
        }
        System.out.println(graphColoring(graph, m, n));
    }

    static boolean graphColoring(boolean[][] graph, int m, int n) {

        int[] colors = new int[n];
        Arrays.fill(colors, m + 1);
        return solve(0, colors, graph, m, n);
    }

    static boolean solve(int index, int[] colors, boolean[][] graph, int m, int n) {


        if (index == n) {
            return true;
        }

        for (int i = 0; i < m; i++) {
            if (canPlace(index, colors, i, graph, n)) {
                colors[index] = i;
                if (solve(index + 1, colors, graph, m, n)) {
                    return true;
                }
                colors[index] = m + 1;
            }
        }
        return false;
    }

    static boolean canPlace(int index, int[] colors, int color, boolean[][] graph, int n) {
        for (int k = 0; k < n; k++) {
            if (graph[index][k] && colors[k] == color) {
                return false;
            }
        }
        return true;
    }
}
