package com.smart.algorithms.sort.common;

/**
 * 选择排序：
 * 遍历数组，每次选出最小值
 */
public class SelectionSort implements InPlaceSort {

    @Override
    public void sort(int[] values) {
        SelectionSort.selectionSort(values);
    }

    public static void selectionSort(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                swap(arr, i, min);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        InPlaceSort sorter = new SelectionSort();
        int[] array = {10, 4, 6, 8, 13, 2, 3};
        sorter.sort(array);
        // Prints:
        // [2, 3, 4, 6, 8, 10, 13]
        System.out.println(java.util.Arrays.toString(array));
    }
}
