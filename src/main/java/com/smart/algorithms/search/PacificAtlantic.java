package com.smart.algorithms.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * https://leetcode-cn.com/problems/pacific-atlantic-water-flow/
 * 太平洋大西洋水流问题
 */
public class PacificAtlantic {

    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private static int numRows;
    private static int numCols;
    private static int[][] landHeights;

    public static List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return Collections.emptyList();
        }
        numRows = matrix.length;
        numCols = matrix[0].length;
        landHeights = matrix;
        boolean[][] pReachable = new boolean[numRows][numCols];
        boolean[][] aReachable = new boolean[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            dfs(i, 0, pReachable);
            dfs(i, numCols - 1, aReachable);
        }
        for (int i = 0; i < numCols; i++) {
            dfs(0, i, pReachable);
            dfs(numRows - 1, i, aReachable);
        }
        List<List<Integer>> commonCells = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (pReachable[i][j] && aReachable[i][j]) {
                    commonCells.add(List.of(i, j));
                }
            }
        }
        return commonCells;
    }

    private static void dfs(int row, int col, boolean[][] reachable) {
        reachable[row][col] = true;
        for (int[] dir : DIRECTIONS) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow < 0 || newCol < 0 || newRow >= numRows || newCol >= numCols) {
                continue;
            }
            if (reachable[newRow][newCol]) {
                continue;
            }
            if (landHeights[newRow][newCol] < landHeights[row][col]) {
                continue;
            }
            dfs(newRow, newCol, reachable);
        }
    }

    //output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4},
        };
        List<List<Integer>> lists = pacificAtlantic(arr);
        System.out.println(lists.toString());
    }
}
