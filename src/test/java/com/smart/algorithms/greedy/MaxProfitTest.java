package com.smart.algorithms.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxProfitTest {

    @Test
    void maxProfit() {
        int i = MaxProfit.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        assertEquals(7, i);
    }
}