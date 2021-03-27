package com.smart.algorithms.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindMinArrowShotsTest {

    @Test
    void findMinArrowShots() {

        int count = FindMinArrowShots.findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}});
        assertEquals(2, count);

        int count1 = FindMinArrowShots.findMinArrowShots(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}});
        assertEquals(4, count1);
    }
}