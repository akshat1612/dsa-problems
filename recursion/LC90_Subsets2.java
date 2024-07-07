package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC90_Subsets2 {
    public static void main(String[] args) {
        int[] candidates = {1, 2, 2, 3, 3};
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.subsetsWithDup(candidates);
        System.out.println(lists);
    }
}

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        subsets(0, nums, new ArrayList<>(), ans);
        return ans;
    }

    void subsets(int index, int[] nums, List<Integer> ds, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(ds));
        if (index == nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            ds.add(nums[i]);
            subsets(i + 1, nums, ds, ans);
            ds.remove(ds.size() - 1);
        }
    }
}
