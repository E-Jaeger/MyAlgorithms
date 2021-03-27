package com.smart.algorithms.search;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/combination-sum-ii/
 * 组合总和 II
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, target, 0, res, new ArrayDeque<>());
        return res;
    }

    private void dfs(int[] candidates, int target, int begin, List<List<Integer>> res, ArrayDeque<Integer> path) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.addLast(candidates[i]);
            System.out.println("递归之前 => " + path + "，剩余 = " + (target - candidates[i]));
            dfs(candidates, target - candidates[i], i + 1, res, path);
            path.removeLast();
             System.out.println("递归之后 => " + path + "，剩余 = " + (target - candidates[i]));
        }
    }


    public static void main(String[] args) {
        //1 1 2 5 6 7 10
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        CombinationSum2 solution = new CombinationSum2();
        List<List<Integer>> res = solution.combinationSum2(candidates, target);
        System.out.println("输出 => " + res);
    }

}
