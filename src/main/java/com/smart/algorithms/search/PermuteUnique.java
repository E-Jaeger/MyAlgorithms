package com.smart.algorithms.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations-ii/
 * 全排列 II
 */
public class PermuteUnique {

    static boolean[] vis;

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> perm = new ArrayList<Integer>();
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, ans, perm);
        return ans;
    }

    public static void dfs(int[] nums, List<List<Integer>> ans, List<Integer> perm) {
        if (perm.size() == nums.length) {
            ans.add(new ArrayList<Integer>(perm));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            perm.add(nums[i]);
            vis[i] = true;
            dfs(nums, ans, perm);
            vis[i] = false;
            perm.remove(perm.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = permuteUnique(new int[]{1, 1, 2});
        System.out.println(lists);
    }


}
