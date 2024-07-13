package slidingWindow;

public class LC485_Max_Consecutive_Ones {
    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes(nums));

        int[] nums2 = {1, 0, 1, 1, 0, 1};
        System.out.println(findMaxConsecutiveOnes(nums2));
    }

    static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int ans = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                if (count > ans) {
                    ans = count;
                }
                count = 0;
            }
        }
        return Math.max(count, ans);
    }
}
