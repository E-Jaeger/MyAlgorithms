package com.smart.algorithms.binarySearch;

/**
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 * 寻找旋转排序数组中的最小值
 */
public class FindMin {

    public static int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums[nums.length - 1] > nums[0]) {
            return nums[0];
        }
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            if (nums[mid] > nums[0]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
