package com.smart.algorithms.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CandyTest {

    @Test
    void assignCandy() {
        int[] a = {1, 2, 3, 4, 5, 3, 2, 1, 2, 6, 5, 4, 3, 3, 2, 1, 1, 3, 3, 3, 4, 2};
        int result = Candy.assignCandy(a);
        assertEquals(47, result);
        int result2 = Candy.assignCandy2(a);
        assertEquals(result, result2);
        assertEquals(5, Candy.assignCandy(new int[]{1, 0, 2}));
        // 1 2 3 4 5 3 2 1  // 1 2 6 5 4 3 3  // 3 2 1 1  // 1 3 3 3  // 3 4 2
        // 1 2 3 4 5 3 2 1  // 1 2 4 3 2 1    // 3 2 1    // 1 2      // 1 2 1
        // r=21             // r=34           // r=40     // r=44     // r=47
    }
}