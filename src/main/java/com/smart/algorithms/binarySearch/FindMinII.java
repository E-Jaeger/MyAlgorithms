package com.smart.algorithms.binarySearch;

/**
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 * 寻找旋转排序数组中的最小值 II
 */
public class FindMinII {

    public static int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[end]) {
                end = mid;
            } else if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end--;
            }
        }
        return nums[start];
    }
    // 1349
    // 11233 44 56789

    // 1349
    // 12345678
}
