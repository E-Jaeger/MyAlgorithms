package com.smart.algorithms.sort.common;

/**
 * 堆排序
 */
public class HeapSort implements InPlaceSort {

    @Override
    public void sort(int[] values) {
        HeapSort.heapsort(values);
    }

    private static void heapsort(int[] ar) {
        if (ar == null) {
            return;
        }
        int n = ar.length;
        for (int i = Math.max(0, n / 2 - 1); i >= 0; i--) {
            sink(ar, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            swap(ar, 0, i);
            sink(ar, i, 0);
        }
    }

    private static void sink(int[] ar, int n, int i) {
        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int largest = i;
            if (right < n && ar[right] > ar[largest]) {
                largest = right;
            }
            if (left < n && ar[left] > ar[largest]) {
                largest = left;
            }
            if (largest != i) {
                swap(ar, largest, i);
                i = largest;
            } else {
                break;
            }
        }
    }

    private static void swap(int[] ar, int i, int j) {
        int tmp = ar[i];
        ar[i] = ar[j];
        ar[j] = tmp;
    }

    /* TESTING */
    public static void main(String[] args) {
        HeapSort sorter = new HeapSort();
        int[] array = {10, 4, 6, 4, 8, -13, 2, 3};
        sorter.sort(array);
        // Prints:
        // [-13, 2, 3, 4, 4, 6, 8, 10]
        System.out.println(java.util.Arrays.toString(array));
    }
}
