package recursion;

import java.util.ArrayList;
import java.util.List;

public class LC98_Subsets {
    public static void main(String[] args) {
        int[] candidates = {1, 2, 3};
        List<List<Integer>> lists = subsets(candidates);
        System.out.println(lists);
    }

    static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, nums, new ArrayList<>(), ans);
        return ans;
    }

    static void solve(int index, int[] nums, List<Integer> ds, List<List<Integer>> ans) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        ds.add(nums[index]);
        solve(index + 1, nums, ds, ans);
        ds.remove(ds.size() - 1);
        solve(index + 1, nums, ds, ans);
    }
}
