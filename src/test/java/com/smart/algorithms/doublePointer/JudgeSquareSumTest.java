package com.smart.algorithms.doublePointer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JudgeSquareSumTest {

    @Test
    void judgeSquareSum() {
        boolean b = JudgeSquareSum.judgeSquareSum(5);
        boolean b1 = JudgeSquareSum.judgeSquareSum(3);
        boolean c = JudgeSquareSum.judgeSquareSum2(5);

        assertTrue(b);
        assertFalse(b1);
        assertTrue(c);
    }
}