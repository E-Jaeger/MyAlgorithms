package com.smart.algorithms.search;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/max-area-of-island/
 * 岛屿的最大面积
 */
public class MaxAreaOfIsland {

    /**
     * 深度优先搜索（递归）
     * @param grid
     * @return
     */
    public static int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                res = Math.max(res, dfs(i, j, grid));
            }
        }
        return res;
    }

    private static int dfs(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        int num = 1;
        grid[i][j] = 0;
        num += dfs(i + 1, j, grid);
        num += dfs(i - 1, j, grid);
        num += dfs(i, j + 1, grid);
        num += dfs(i, j - 1, grid);
        return num;
    }

    /**
     * 深度优先搜索（栈）
     * @param grid
     * @return
     */
    public static int maxAreaOfIsland2(int[][] grid) {
        //todo
        Deque<int[]> stack = new LinkedList<>();

        int[][] moveIndexArray = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                stack.push(new int[]{i, j});
                //计算最大面积
                int currMaxArea = 0;
                while (!stack.isEmpty()) {
                    int[] pop = stack.pop();
                    int currI = pop[0];
                    int currJ = pop[1];
                    if (currI < 0 || currI >= grid.length || currJ < 0 || currJ >= grid[0].length || grid[currI][currJ] == 0) {
                        continue;
                    }
                    currMaxArea++;
                    grid[currI][currJ] = 0;
                    for (int[] moveIndex : moveIndexArray) {
                        stack.push(new int[]{currI + moveIndex[0], currJ + moveIndex[1]});
                    }
                }
                maxArea = Math.max(currMaxArea, maxArea);
            }
        }

        return maxArea;
    }

    //output: 6
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0},
        };
        int i = maxAreaOfIsland(grid);
        System.out.println(i);
    }
}
