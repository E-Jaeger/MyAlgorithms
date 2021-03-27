package com.smart.algorithms.sort.common;

import java.util.Arrays;

/**
 * 插入排序：
 * 假设[0-i]是排好序的，那么第i个数依次和第i-1...0比较，如果第i个数小就交换位置
 */
public class InsertionSort implements InPlaceSort {

    @Override
    public void sort(int[] values) {
        InsertionSort.insertionSort(values);
    }

    public static void insertionSort(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                swap(arr, j - 1, j);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        InPlaceSort sorter = new InsertionSort();
        int[] arr = {10, 4, 6, 8, 13, 2, 3};
        sorter.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
