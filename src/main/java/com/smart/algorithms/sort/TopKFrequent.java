package com.smart.algorithms.sort;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 * 前 K 个高频元素
 */
public class TopKFrequent {

    /**
     * 方法一：最小堆
     *
     * 借助哈希表维护一个元素和出现次数的映射，
     * 维护一个长度为k的最小堆，出现次数作为优先指标（堆顶元素为出现频率最少的元素），
     * 遍历哈希表，每次都将新元素与堆顶元素进行比较，
     * 如果新元素的频率比堆顶元素的频率大，则弹出堆顶元素，将新元素入堆
     * 最终堆中的k个元素即为前k个高频元素
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        for (int j : nums) {
            map.put(j, map.getOrDefault(j, 0) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll()[0];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = topKFrequent(new int[]{3, 3, 3, 3, 3, 14, 3545, 22, 456, 1, 1, 1, 2, 2, 3}, 3);
        String s = Arrays.toString(ints);
        System.out.println(s);
    }
}