package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class LC46_Permutations_approach1 {
    public static void main(String[] args) {
        int[] candidates = {1, 2, 3};
        List<List<Integer>> lists = permute(candidates);
        System.out.println(lists);
    }

    static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<Integer> included = new HashSet<>();
        solve(0, nums, new ArrayList<>(), included, ans);
        return ans;
    }

    static void solve(int index, int[] nums, List<Integer> ds, Set<Integer> included, List<List<Integer>> ans) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(ds));
        }

        for (int i = 0; i < nums.length; i++) {
            if (included.contains(nums[i])) {
                continue;
            }
            included.add(nums[i]);
            ds.add(nums[i]);
            solve(index+1, nums, ds, included, ans);
            ds.remove(ds.size() - 1);
            included.remove(nums[i]);
        }
    }
}
