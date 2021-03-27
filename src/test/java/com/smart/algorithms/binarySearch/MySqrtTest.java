package com.smart.algorithms.binarySearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MySqrtTest {

    @Test
    void mySqrt() {
        int i = MySqrt.mySqrt(4);
        int i2 = MySqrt.mySqrt(8);
        int i3 = MySqrt.mySqrt2(4);
        int i4 = MySqrt.mySqrt2(8);

        assertEquals(2, i);
        assertEquals(2, i2);
        assertEquals(2, i3);
        assertEquals(2, i4);
    }
}