package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC40_CombinationSum2 {
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5,8};
        int target = 8;
        Arrays.sort(candidates);
        List<List<Integer>> lists = combinationSum2(candidates, target);
        System.out.println(lists);
    }

    static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(0, candidates, target, new ArrayList<>(), ans);
        return ans;
    }

    static void findCombinations(int index, int[] candidates, int target, List<Integer> ds, List<List<Integer>> ans) {
        if (index == candidates.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if ((i > index) && (candidates[i] == candidates[i - 1])) {
                continue;
            }
            if (target >= candidates[i]) {
                ds.add(candidates[i]);
                findCombinations(i+1, candidates, target - candidates[i], ds, ans);
                ds.remove(ds.size() - 1);
            } else {
                break;
            }
        }
    }
}