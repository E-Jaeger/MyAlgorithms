package com.smart.algorithms.binarySearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindMinIITest {

    @Test
    void findMin() {
        int min = FindMinII.findMin(new int[]{1, 3, 5});
        int min2 = FindMinII.findMin(new int[]{2, 2, 2, 0, 1});
        assertEquals(1, min);
        assertEquals(0, min2);
    }
}