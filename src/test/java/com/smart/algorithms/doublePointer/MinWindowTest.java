package com.smart.algorithms.doublePointer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinWindowTest {

    @Test
    void minWindow() {
        String s = MinWindow.minWindow("ADOBECODEBANC", "ABC");
        assertEquals("BANC", s);

        String s2 = MinWindow.minWindow("a", "a");
        assertEquals("a", s2);
    }
}