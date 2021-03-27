package com.smart.algorithms.search;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations/
 * 全排列
 */
public class Permute {

    public static List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int[] visited = new int[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, nums, new ArrayList<Integer>(), visited);
        return res;
    }

    private static void dfs(List<List<Integer>> res, int[] nums, ArrayList<Integer> tmp, int[] visited) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) {
                continue;
            }
            visited[i] = 1;
            tmp.add(nums[i]);
            dfs(res, nums, tmp, visited);
            tmp.remove(tmp.size() - 1);
            visited[i] = 0;
        }

        //4 res=[1,1,2] return
        //3 i=0,v=[1,1,1],tmp=[1,1,2]
        //2 i=0,v=[1,1,0],tmp=[1,1]
        //1 i=0,v=[1,0,0],tmp=[1]
    }


    public static void main(String[] args) {
        List<List<Integer>> permute = permute(new int[]{1, 2, 3});
        System.out.println(permute);
    }
}
