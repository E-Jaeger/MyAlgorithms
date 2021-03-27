package com.smart.algorithms.greedy;

/**
 * 种花问题
 * https://leetcode-cn.com/problems/can-place-flowers/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china
 */
public class CanPlaceFlowers {

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            if (n <= 0) {
                return true;
            }
            if (flowerbed[i] == 1) {
                continue;
            }
            if (i > 0 && flowerbed[i - 1] == 1) {
                continue;
            }
            if (i < flowerbed.length - 1 && flowerbed[i + 1] == 1) {
                continue;
            }
            flowerbed[i] = 1;
            n--;
        }
        return n <= 0;
    }
}
