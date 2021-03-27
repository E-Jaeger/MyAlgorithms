package com.smart.algorithms.binarySearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindMedianSortedArraysTest {

    @Test
    void findMedianSortedArrays() {
        double r1 = FindMedianSortedArrays.findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
        double r2 = FindMedianSortedArrays.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        double r3 = FindMedianSortedArrays.findMedianSortedArrays(new int[]{0, 0}, new int[]{0, 0});
        double r4 = FindMedianSortedArrays.findMedianSortedArrays(new int[]{}, new int[]{1});
        double r5 = FindMedianSortedArrays.findMedianSortedArrays(new int[]{2}, new int[]{});
        assertEquals(2.0, r1);
        assertEquals(2.5, r2);
        assertEquals(0.0, r3);
        assertEquals(1.0, r4);
        assertEquals(2.0, r5);

    }
}