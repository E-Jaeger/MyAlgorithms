package com.smart.algorithms.greedy;

import java.util.Arrays;

/**
 * 用最少数量的箭引爆气球
 * https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/
 */
public class FindMinArrowShots {

    public static int findMinArrowShots(int[][] points) {
        if (points.length < 1) {
            return 0;
        }
        int count = 1;
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                count++;
                end = points[i][1];
            }
        }
        return count;
    }
}
