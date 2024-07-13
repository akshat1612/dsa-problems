package slidingWindow;

public class LC1004_Max_Consecutive_Ones_III {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        System.out.println(longestOnes(nums, 2));

        int[] nums2 = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        System.out.println(longestOnes(nums2, 3));
    }

    static int longestOnes(int[] nums, int k) {
        int count0 = 0;
        int ans = 0;
        int r = 0;
        int l = 0;

        while (r < nums.length) {
            if (nums[r] == 0) {
                count0++;
            }
            if (count0 > k) {
                if (nums[l] == 0) count0--;
                l++;
            }
            if (count0 <= k) {
                ans = Math.max(ans, r - l + 1);
            }
            r++;
        }
        return ans;
    }
}
