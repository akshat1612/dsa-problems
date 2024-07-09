package recursion;

import java.util.Arrays;

public class LC912_MergeSort {
    public static void main(String[] args) {
        int[] candidates = {1, 4, 2, 3, 7, 3, 23, 354, 324, 1246, 453};
        mergeSort(candidates, 0, candidates.length - 1);
        System.out.println(Arrays.stream(candidates).boxed().toList());
    }

    static void mergeSort(int[] nums, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int mid = begin + (end - begin) / 2;

        mergeSort(nums, begin, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, begin, mid, mid + 1, end);
    }

    static void merge(int[] nums, int begin1, int end1, int begin2, int end2) {
        int[] temp = new int[end2 - begin1 + 1];
        int index = 0;
        int start = begin1;
        while ((begin1 <= end1) && (begin2 <= end2)) {
            if (nums[begin1] <= nums[begin2]) {
                temp[index++] = nums[begin1];
                begin1++;
            } else {
                temp[index++] = nums[begin2];
                begin2++;
            }
        }
        while (begin1 <= end1) {
            temp[index++] = nums[begin1++];
        }

        while (begin2 <= end2) {
            temp[index++] = nums[begin2++];
        }

        for (int j : temp) {
            nums[start++] = j;
        }
    }
}