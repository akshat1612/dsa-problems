package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC39_CombinationSum1 {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> lists = combinationSum(candidates, target);
        System.out.println(lists);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0, candidates, target, new ArrayList<>(), ans);
        return ans;
    }

    static void findCombinations(int index, int[] candidates, int target, List<Integer> ds, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        if (index == candidates.length) {
            return;
        }
        if (target >= candidates[index]) {
            ds.add(candidates[index]);
            findCombinations(index, candidates, (target - candidates[index]), ds, ans);
            ds.remove(ds.size() - 1);
            findCombinations(index + 1, candidates, target, ds, ans);
        }
    }
}