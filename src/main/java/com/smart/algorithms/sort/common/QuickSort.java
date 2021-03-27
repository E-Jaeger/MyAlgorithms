package com.smart.algorithms.sort.common;

/**
 * 快速排序
 */
public class QuickSort implements InPlaceSort{

    @Override
    public void sort(int[] values) {
        QuickSort.quicksort(values);
    }

    public static void quicksort(int[] ar) {
        if (ar == null) return;
        sort(ar, 0, ar.length - 1);
    }

    private static void sort(int[] arr, int low, int height) {
        if (low >= height) {
            return;
        }
        int left = low, right = height;
        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        sort(arr, low, left - 1);
        sort(arr, left + 1, height);
    }

    public static void main(String[] args) {
        InPlaceSort sorter = new QuickSort();
        int[] array = {10, 4, 6, 4, 8, -13, 2, 3};
        sorter.sort(array);
        // Prints:
        // [-13, 2, 3, 4, 4, 6, 8, 10]
        System.out.println(java.util.Arrays.toString(array));
    }

}
