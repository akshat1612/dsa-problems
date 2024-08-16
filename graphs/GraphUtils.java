package graphs;

import java.util.ArrayList;

/**
 * Util for Graphs questions
 */
public class GraphUtils {

    public static ArrayList<ArrayList<Integer>> createAdjacencyArray(int[][] adjacency) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int[] ints : adjacency) {
            ArrayList<Integer> arr = new ArrayList<>();
            for (int b : ints) {
                arr.add(b);
            }
            ans.add(arr);
        }
        return ans;
    }
}
