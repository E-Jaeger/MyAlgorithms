package com.smart.algorithms.doublePointer;

/**
 * https://leetcode-cn.com/problems/minimum-window-substring/
 * 最小覆盖子串
 */
public class MinWindow {

    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }
        String res = "";
        //用于统计目标字符串中的每个字母及其数量
        int[] need = new int[128];
        //用于统计当前滑动窗口中的每个字母及其数量
        int[] window = new int[128];
        //左右指针
        int left = 0, right = 0;
        //窗口中已经匹配的字符个数
        int count = 0;

        //满足条件的最短长度
        int minLength = s.length();

        //统计目标字符串中的每个字母及其数量
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        while (right < s.length()) {
            char ch = s.charAt(right);
            window[ch]++;
            //如果当前字符是需要的并且当前滑动窗口中的数量小于所需要的数量，则count++
            if (need[ch] > 0 && need[ch] >= window[ch]) {
                count++;
            }
            //如果当前窗口已经包含目标中的所有字符，则left收缩，直到窗口不全包含目标字符集
            while (count == t.length()) {
                ch = s.charAt(left);
                if (need[ch] > 0 && need[ch] >= window[ch]) {
                    count--;
                }
                if (right - left + 1 <= minLength) {
                    minLength = right - left + 1;
                    res = s.substring(left, right + 1);
                }
                window[ch]--;
                left++;
            }
            right++;
        }
        return res;
    }
}
