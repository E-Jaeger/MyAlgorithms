package com.smart.algorithms.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 根据身高重建队列
 * https://leetcode-cn.com/problems/queue-reconstruction-by-height/
 */
public class ReconstructQueue {

    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
        List<int[]> res = new ArrayList<>();
        for (int[] i : people) {
            res.add(i[1], i);
        }
        return res.toArray(new int[0][2]);
    }

}
