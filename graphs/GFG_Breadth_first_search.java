package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GFG_Breadth_first_search {

    public static void main(String[] args) {
        int[][] adjacency = {{1,2,3},{},{4},{},{}};
        System.out.println(bfsOfGraph(adjacency.length, GraphUtils.createAdjacencyArray(adjacency)));
    }

    static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[V];
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = 1;
        while(!q.isEmpty()) {
            int element = q.poll();
            ans.add(element);
            for(int ele: adj.get(element)) {
                if(visited[ele] != 1) {
                    visited[ele]++;
                    q.add(ele);
                }
            }
        }
        return ans;
    }
}
