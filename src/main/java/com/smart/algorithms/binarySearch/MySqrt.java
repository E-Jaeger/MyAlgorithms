package com.smart.algorithms.binarySearch;

public class MySqrt {

    public static int mySqrt(int x) {
        int start = 0, end = x, res = -1;
        while (start <= end) {
            int mid = (end - 1) / 2 + 1;
            if (mid * mid <= x) {
                res = mid;
                start++;
            } else {
                end--;
            }
        }
        return res;
    }

    public static int mySqrt2(int x) {
        if (x == 0) {
            return 0;
        }
        double x0 = x;
        while (true) {
            double a = 0.5 * (x0 + (double) x / x0);
            if (Math.abs(a - x0) < 1e-7) {
                break;
            }
            x0 = a;
        }
        return (int) x0;
    }
}