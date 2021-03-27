package com.smart.algorithms.greedy;

/**
 * 非递减数列
 * https://leetcode-cn.com/problems/non-decreasing-array/
 */
public class CheckPossibility {

    public static boolean checkPossibility(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        boolean flag = nums[1] >= nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (flag) {
                    if (nums[i + 1] >= nums[i - 1]) {
                        nums[i] = nums[i + 1];
                    } else {
                        nums[i + 1] = nums[i];
                    }
                    flag = false;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
