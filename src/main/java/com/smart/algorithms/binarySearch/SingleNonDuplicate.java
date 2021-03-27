package com.smart.algorithms.binarySearch;

/**
 * https://leetcode-cn.com/problems/single-element-in-a-sorted-array/
 * 有序数组中的单一元素
 */
public class SingleNonDuplicate {

    public static int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            boolean isEven = (end - mid) % 2 == 0;
            if (nums[mid + 1] == nums[mid]) {
                if (isEven) {
                    start = mid + 2;
                } else {
                    end = mid - 1;
                }
            } else if (nums[mid - 1] == nums[mid]) {
                if (isEven) {
                    end = mid - 2;
                } else {
                    start = mid + 1;
                }
            } else {
                return nums[mid];
            }
        }
        return nums[start];
    }

}
