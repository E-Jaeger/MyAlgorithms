package com.smart.algorithms.binarySearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleNonDuplicateTest {

    @Test
    void singleNonDuplicate() {
        int i = SingleNonDuplicate.singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8});
        assertEquals(2, i);

        int i1 = SingleNonDuplicate.singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11});
        assertEquals(10, i1);
    }
}