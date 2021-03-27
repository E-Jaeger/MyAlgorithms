package com.smart.algorithms.doublePointer;

/**
 *  两数之和 II - 输入有序数组
 *  https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class TwoSum {
    public static int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            if (numbers[start] + numbers[end] == target) {
                break;
            } else if (numbers[start] + numbers[end] < target) {
                start++;
            } else if (numbers[start] + numbers[end] > target) {
                end--;
            }
        }
        return new int[]{start+1,end+1};
    }

    public static void main(String[] args) {
        int[] ints = TwoSum.twoSum(new int[]{2, 7, 11, 15}, 9);
        for (int a : ints) {
            System.out.println(a);
        }
    }
}
