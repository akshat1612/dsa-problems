package backtracking;

import java.util.Arrays;

public class LC1042_FlowerPlanting {

    public static void main(String[] args) {
        int n = 4;
        int[][] paths = {{1, 2}, {3, 4}};
        System.out.println(Arrays.stream(gardenNoAdj(n, paths)).boxed().toList());
    }

    static int[] gardenNoAdj(int n, int[][] paths) {
        boolean[][] graph = new boolean[n][n];
        for (int[] path : paths) {
            graph[path[0] - 1][path[1] - 1] = true;
            graph[path[1] - 1][path[0] - 1] = true;
        }

        int[] gardens = new int[n];
        Arrays.fill(gardens, n + 1);
        int[] ans = new int[n];
        solve(0, graph, gardens, n);
        return gardens;
    }

    static boolean solve(int index, boolean[][] graph, int[] gardens, int n) {
        if (index == n) {
            return true;
        }
        for (int i = 1; i < 5; i++) {
            if (canPlace(i, index, graph, gardens, n)) {
                gardens[index] = i;
                if (solve(index + 1, graph, gardens, n)) {
                    return true;
                } else {
                    gardens[index] = n + 1;
                }
            }
        }
        return false;
    }

    static boolean canPlace(int flower, int garden, boolean[][] graph, int[] gardens, int n) {
        for (int i = 0; i < n; i++) {
            if (graph[garden][i] && gardens[i] == flower) {
                return false;
            }
        }
        return true;
    }
}
