package com.smart.algorithms.binarySearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindMinTest {

    @Test
    void findMin() {
        int min = FindMin.findMin(new int[]{3, 4, 5, 1, 2});
        int min1 = FindMin.findMin(new int[]{4, 5, 6, 7, 0, 1, 2});
        int min2 = FindMin.findMin(new int[]{1});
        assertEquals(1, min);
        assertEquals(0, min1);
        assertEquals(1, min2);
    }
}
