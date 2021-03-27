package com.smart.algorithms.greedy;

/**
 * 买卖股票的最佳时机 II
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class MaxProfit {
    public static int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int sum=0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                sum += prices[i + 1] - prices[i];
            }
        }
        return sum;
    }

}
