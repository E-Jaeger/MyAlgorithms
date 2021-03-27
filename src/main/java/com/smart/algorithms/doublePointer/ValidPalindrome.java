package com.smart.algorithms.doublePointer;

/**
 * https://leetcode-cn.com/problems/valid-palindrome-ii/
 * 验证回文字符串 Ⅱ
 */
public class ValidPalindrome {

    public static boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return isValid(s, start + 1, end) || isValid(s, start, end - 1);
            }
        }
        return true;
    }

    public static boolean isValid(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
