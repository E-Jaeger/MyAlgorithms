package com.smart.algorithms.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AssignCookiesTest {

    @Test
    void findContentChildren() {
        int[] a = {1, 2};
        int[] b = {1, 2, 3};
        int result = AssignCookies.findContentChildren(a, b);
        assertEquals(2, result);
    }
}