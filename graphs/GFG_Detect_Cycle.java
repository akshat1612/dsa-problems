package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GFG_Detect_Cycle {

    public static void main(String[] args) {
        int[][] adjacency = {{1}, {0, 2, 4}, {1, 3}, {2, 4}, {1, 3}};
        System.out.println(isCycle(adjacency.length, GraphUtils.createAdjacencyArray(adjacency)));

        adjacency = new int[][]{{}, {2}, {1, 3}, {2}};
        System.out.println(isCycle(adjacency.length, GraphUtils.createAdjacencyArray(adjacency)));


    }

    static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {

        int[] visited = new int[V];
        int[] visitedBy = new int[V];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (visited[i] != 1) {
                q.add(i);
                visitedBy[i] = -1;
                visited[i] = 1;
                if (helper(q, visited, visitedBy, adj)) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean helper(Queue<Integer> q, int[] visited, int[] visitedBy, ArrayList<ArrayList<Integer>> adj) {
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int n : adj.get(node)) {
                if (visited[n] == 1) {
                    if (visitedBy[node] != n) {
                        return true;
                    }
                } else {
                    q.add(n);
                    visited[n] = 1;
                    visitedBy[n] = node;
                }
            }
        }
        return false;
    }
}
