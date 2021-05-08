package com.smart.algorithms.dynamicProgramming;

/**
 * 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class ClimbStairs {

    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int p = 1, q = 2, cur = 0;
        for (int i = 2; i < n; i++) {
            cur = p + q;
            p = q;
            q = cur;
        }
        return cur;
    }

    public static void main(String[] args) {
        //output:4181
        System.out.println(climbStairs(18));
    }
}
