package com.smart.algorithms.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 无重叠区间
 * https://leetcode-cn.com/problems/non-overlapping-intervals/
 */
public class EraseOverlapIntervals {
    public static int doEraseOverlapIntervals(int[][] intervals) {
        if (intervals.length==0) return 0;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int end = intervals[0][1];
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                count++;
                end = Math.min(end, intervals[i][1]);
            } else {
                end = intervals[i][1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int a = 0;
        while (true){
            if (a==0) break;
            System.out.println("fuck");
        }
    }
}
