package com.smart.algorithms.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CanPlaceFlowersTest {

    @Test
    void canPlaceFlowers() {
        boolean t = CanPlaceFlowers.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1);
        boolean f = CanPlaceFlowers.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2);
        assertTrue(t);
        assertFalse(f);
    }
}