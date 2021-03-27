package com.smart.algorithms.binarySearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchRangeTest {

    @Test
    void searchRange() {
        int[] ints = SearchRange.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        int[] ints1 = SearchRange.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
        int[] ints2 = SearchRange.searchRange(new int[]{}, 0);
        assertEquals(3, ints[0]);
        assertEquals(4, ints[1]);
        assertEquals(-1, ints1[0]);
        assertEquals(-1, ints1[1]);
        assertEquals(-1, ints2[0]);
        assertEquals(-1, ints2[1]);
    }
}