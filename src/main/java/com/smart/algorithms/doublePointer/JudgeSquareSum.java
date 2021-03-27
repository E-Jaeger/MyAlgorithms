package com.smart.algorithms.doublePointer;

/**
 * https://leetcode-cn.com/problems/sum-of-square-numbers/
 * 平方数之和
 */
public class JudgeSquareSum {
    public static boolean judgeSquareSum(int c) {
        int start = 0;
        int end = (int) Math.sqrt(c);
        while (start <= end) {
            int a = start * start + end * end;
            if (a > c) {
                end--;
            } else if (a < c) {
                start++;
            } else {
                return true;
            }
        }
        return false;
    }

    public static boolean judgeSquareSum2(int c) {
        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b) {
                return true;
            }
        }
        return false;
    }

}
