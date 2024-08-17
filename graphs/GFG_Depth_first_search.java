package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GFG_Depth_first_search {

    public static void main(String[] args) {
        int[][] adjacency = {{1,2,3},{},{4},{},{}};
        System.out.println(dfsOfGraph(adjacency.length, GraphUtils.createAdjacencyArray(adjacency)));
    }

    static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        int[] visited = new int[V];
        dfs(0, adj, ans, visited);
        return ans;
    }

    static void dfs(int currentVertex, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans, int[] visited) {
        visited[currentVertex] = 1;
        ans.add(currentVertex);
        for(int v: adj.get(currentVertex)) {
            if(visited[v] != 1) {
                dfs(v, adj, ans, visited);
            }
        }
    }
}
