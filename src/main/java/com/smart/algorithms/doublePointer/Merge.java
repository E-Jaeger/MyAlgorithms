package com.smart.algorithms.doublePointer;

/**
 * https://leetcode-cn.com/problems/merge-sorted-array/
 * 合并两个有序数组
 */
public class Merge {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while (p1 >= 0 && p2 >= 0) {
            nums1[p--] = nums2[p2] > nums1[p1] ? nums2[p2--] : nums1[p1--];
        }
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
        for (int a : nums1) {
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        Merge.merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }
}
