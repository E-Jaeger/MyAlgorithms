package com.smart.algorithms.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EraseOverlapIntervalsTest {

    @Test
    void doEraseOverlapIntervals() {
        int[][] arr1 = new int[][]{{1, 2}, {2, 4}, {1, 3}};
        int[][] arr2 = new int[][]{{1, 2}, {1, 2}, {1, 2}};
        int[][] arr3 = new int[][]{{1, 2}, {2, 3}};
        int r = EraseOverlapIntervals.doEraseOverlapIntervals(arr1);
        int r2 = EraseOverlapIntervals.doEraseOverlapIntervals(arr2);
        int r3 = EraseOverlapIntervals.doEraseOverlapIntervals(arr3);
        assertEquals(1, r);
        assertEquals(2, r2);
        assertEquals(0, r3);
    }
}