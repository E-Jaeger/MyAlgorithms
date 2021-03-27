package com.smart.algorithms.greedy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ReconstructQueueTest {

    @Test
    void reconstructQueue() {
        int[][] queue = ReconstructQueue.reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});
        for (int[] ints : queue) {
            System.out.println(Arrays.toString(ints));
        }
    }
}