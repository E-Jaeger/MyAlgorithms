package com.smart.algorithms.greedy;

import java.util.Arrays;

/**
 * 分发糖果
 * https://leetcode-cn.com/problems/candy/
 */
public class Candy {

    public static int assignCandy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        int sum = candies[ratings.length - 1];
        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                candies[i - 1] = Math.max(candies[i - 1], candies[i] + 1);
            }
            sum += candies[i - 1];
        }
        return sum;
    }

    public static int assignCandy2(int[] ratings) {
        int len = ratings.length;
        if (len == 1) {
            return 1;
        }
        int index = 0;
        int total = 0;
        while (index < len - 1) {
            int up = 0;
            while (index < len - 1 && ratings[index + 1] > ratings[index]) {
                index++;
                up++;
            }
            int down = 0;
            while (index < len - 1 && ratings[index + 1] < ratings[index]) {
                index++;
                down++;
            }
            int peekCount = Math.max(up, down) + 1;
            if (total != 0) {
                total--;
            }
            total += count(up) + count(down) + peekCount;
            while (index < len - 1 && ratings[index + 1] == ratings[index]) {
                index++;
                total++;
            }
        }
        return total;
    }

    public static int count(int n) {
        return (n * (n + 1)) / 2;
    }

}
