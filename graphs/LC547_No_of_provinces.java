package graphs;

public class LC547_No_of_provinces {

    public static void main(String[] args) {
        int[][] adjacency = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(findCircleNum(adjacency));
    }

    static int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        boolean[] visited = new boolean[V];
        int count = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                count++;
                bfs(i, visited, isConnected);
            }
        }
        return count;
    }

    static void bfs(int V, boolean[] visited, int[][] isConnected) {
        visited[V] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i] && isConnected[V][i] == 1) {
                bfs(i, visited, isConnected);
            }
        }
    }
}
