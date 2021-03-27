package com.smart.algorithms.doublePointer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidPalindromeTest {

    @Test
    void validPalindrome() {
        boolean t = ValidPalindrome.validPalindrome("aba");
        assertTrue(t);
    }
}