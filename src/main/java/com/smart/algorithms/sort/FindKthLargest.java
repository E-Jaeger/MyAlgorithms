package com.smart.algorithms.sort;

import java.util.Random;

/**
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * 数组中的第K个最大元素
 */
public class FindKthLargest {

    private static Random random = new Random(System.currentTimeMillis());

    /**
     * 方法一：快速排序
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        int target = nums.length - k;
        while (true) {
            int index = partition(nums, left, right);
            if (target == index) {
                return nums[index];
            } else if (index < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
    }

    // 在区间 [left, right] 这个区间执行 partition 操作
    private static int partition(int[] nums, int left, int right) {
        // 在区间随机选择一个元素作为标定点
        if (left < right) {
            int randomIndex = left + 1 + random.nextInt(right - left);
            swap(nums, left, randomIndex);
        }
        int i = left + 1, j = right;
        int pivot = nums[left];
        while (true) {
            while (i < right && nums[i] <= pivot) {
                i++;
            }
            while (j > left && nums[j] >= pivot) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, left, j);
        return j;
    }

    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    /**
     * 方法二：堆排序
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest2(int[] nums, int k) {//12345
        int n = nums.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            sink(nums, n, i);
        }
        for (int i = n - 1; i >= n - k + 1; i--) {
            swap(nums, 0, i);
            sink(nums, i, 0);
        }
        return nums[0];
    }

    public static void sink(int[] nums, int n, int i) {
        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int largest = i;
            if (left < n && nums[left] > nums[largest]) {
                largest = left;
            }
            if (right < n && nums[right] > nums[largest]) {
                largest = right;
            }
            if (i != largest) {
                swap(nums, i, largest);
                i = largest;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        for (int j = 0; j < 100; j++) {
            int i = findKthLargest2(new int[]{3, 2, 1, 5, 6, 4, 1}, 2);
            System.out.println(i);
        }
    }
}

