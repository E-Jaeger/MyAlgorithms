package com.smart.algorithms.doublePointer;

import java.util.List;

/**
 * https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/
 * 通过删除字母匹配到字典里最长单词
 */
public class FindLongestWord {

    public static String findLongestWord(String s, List<String> dictionary) {
        String str = "";
        for (String sstr : dictionary) {
            for (int i = 0, j = 0; i < s.length() && j < sstr.length(); i++) {
                if (sstr.charAt(j) == s.charAt(i)) {
                    j++;
                }
                if (j == sstr.length()) {
                    if (sstr.length() > str.length() || (sstr.length() == str.length() && sstr.compareTo(str) < 0)) {
                        str = sstr;
                    }
                }
            }
        }
        return str;
    }
}
