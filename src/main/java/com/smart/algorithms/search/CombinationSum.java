package com.smart.algorithms.search;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/combination-sum/
 * 组合总和
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, target, res, new ArrayDeque<>());
        return res;
    }

    private void dfs(int[] candidates, int begin, int target, List<List<Integer>> res, ArrayDeque<Integer> path) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            path.addLast(candidates[i]);
            System.out.println("递归之前 => " + path + "，剩余 = " + (target - candidates[i]));
            dfs(candidates, i, target - candidates[i], res, path);
            path.removeLast();
            System.out.println("递归之后 => " + path);
        }
    }


    public static void main(String[] args) {
        CombinationSum solution = new CombinationSum();
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> res = solution.combinationSum(candidates, target);
        System.out.println("输出 => " + res);
    }


}