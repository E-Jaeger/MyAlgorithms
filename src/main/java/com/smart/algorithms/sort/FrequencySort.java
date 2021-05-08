package com.smart.algorithms.sort;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/sort-characters-by-frequency/
 * 根据字符出现频率排序
 */
public class FrequencySort {

    /**
     * 方法一：桶排序
     *
     * 先统计每个字母出现的次数，
     * 让字母出现的次数作为桶的下标，
     * 出现次数的字母放入对应下标的桶内，
     * 倒序输出桶内的字母
     * @param s
     * @return
     */
    public static String frequencySort(String s) {
        if (null == s || s.length() == 0) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        List<Character>[] buckets = new List[s.length() + 1];
        for (Character ch : map.keySet()) {
            Integer count = map.get(ch);
            if (buckets[count] == null) {
                buckets[count] = new ArrayList<>();
            }
            if (!buckets[count].contains(ch)) {
                buckets[count].add(ch);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = buckets.length - 1; i > 0; i--) {
            if (buckets[i] != null && buckets[i].size() != 0) {
                for (Character ch : buckets[i]) {
                    for (int j = 1; j <= i; j++) {
                        stringBuilder.append(String.valueOf(ch));
                    }
                }
            }
        }

        return String.valueOf(stringBuilder);
    }

    /**
     * 方法二：堆排序
     *
     * @param s
     * @return
     */
    public static Map<Character, Integer> map = new HashMap<>();

    public static String frequencySort2(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        char[] heap = new char[map.size()];
        int index = 0;
        for (Character ch : map.keySet()) {
            heap[index++] = ch;
        }
        int len = heap.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            sink(heap, len, i);
        }
        StringBuilder res = new StringBuilder();
        for (int i = len - 1; i >= 0; i--) {
            swap(heap, 0, i);
            sink(heap, i, 0);
            Integer times = map.get(heap[i]);
            for (int j = 1; j <= times; j++) {
                res.append(String.valueOf(heap[i]));
            }
        }
        System.out.println(Arrays.toString(heap));
        return String.valueOf(res);
    }

    public static void sink(char[] arr, int n, int i) {
        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int largest = i;
            if (right < n && map.get(arr[right]) >= map.get(arr[largest])) {
                largest = right;
            }
            if (left < n && map.get(arr[left]) >= map.get(arr[largest])) {
                largest = left;
            }
            if (i != largest) {
                swap(arr, i, largest);
                i = largest;
            } else {
                break;
            }
        }
    }

    public static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
//        String a = frequencySort2("tree");
//        System.out.println(a);

//        String b = frequencySort2("cccaaa");
//        System.out.println(b);

        String c = frequencySort2("abaccadeeefaafcc");
        System.out.println(c);
    }
}
