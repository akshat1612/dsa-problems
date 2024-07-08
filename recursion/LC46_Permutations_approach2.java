package recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Approach 2 - Swap and permute
 */
public class LC46_Permutations_approach2 {
    public static void main(String[] args) {
        int[] candidates = {1, 2, 3};
        List<List<Integer>> lists = permute(candidates);
        System.out.println(lists);
    }

    static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, nums, new ArrayList<>(), ans);
        return ans;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void solve(int index, int[] nums, List<Integer> ds, List<List<Integer>> ans) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            ds.add(nums[index]);
            solve(index + 1, nums, ds, ans);
            ds.remove(ds.size() - 1);
            swap(nums, i, index);
        }
    }
}
