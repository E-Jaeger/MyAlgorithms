package com.smart.algorithms.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 划分字母区间
 * https://leetcode-cn.com/problems/partition-labels/
 */
public class PartitionLabels {

    public static List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        if (S == null || S.length() == 0) {
            return result;
        }
        int[] lastIndex = new int[26];
        Arrays.fill(lastIndex, -1);
        for (int i = 0; i < S.length(); i++) {
            lastIndex[S.charAt(i) - 'a'] = i;
        }
        int start = 0, end = 0;
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, lastIndex[S.charAt(i) - 'a']);
            if (i == end) {
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = PartitionLabels.partitionLabels("ababcbacadefegdehijhklij");
        System.out.println(result);
    }
}
