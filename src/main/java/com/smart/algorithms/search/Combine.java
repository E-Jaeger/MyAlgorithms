package com.smart.algorithms.search;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combinations/
 * 组合
 */
public class Combine {

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(n, k, 1, res, new ArrayList<Integer>());
        return res;
    }

    public static void dfs(int n, int k, int index, List<List<Integer>> res, ArrayList<Integer> path) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            dfs(n, k, i + 1, res, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        //1 2 3 4
        List<List<Integer>> combine = combine(4, 2);
        System.out.println(combine);
    }
}
