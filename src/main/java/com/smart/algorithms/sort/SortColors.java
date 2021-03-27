package com.smart.algorithms.sort;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/sort-colors/
 * 颜色分类
 */
public class SortColors {

    /**
     * 双指针
     *
     * 从左往右遍历，如果遇到2则和有指针的元素交换位置，如果交换过来的还是2则继续交换，直到不是2为止，
     * 如果当前位置是0，则把0移动到左侧
     * @param nums
     */
    public static void sortColors(int[] nums) {
        int p0 = 0, p2 = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            while (i <= p2 && nums[i] == 2) {
                int tmp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = tmp;
                p2--;
            }
            if (nums[i] == 0) {
                int tmp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = tmp;
                p0++;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 1, 0, 0, 1, 2};
        sortColors(a);
        System.out.println(Arrays.toString(a));
    }
}
