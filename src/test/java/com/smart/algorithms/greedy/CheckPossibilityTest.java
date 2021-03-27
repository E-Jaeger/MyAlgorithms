package com.smart.algorithms.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckPossibilityTest {

    @Test
    void checkPossibility() {
        boolean r = CheckPossibility.checkPossibility(new int[]{4, 2, 3});
        boolean r2 = CheckPossibility.checkPossibility(new int[]{4, 2, 1});
        assertTrue(r);
        assertFalse(r2);
    }
}