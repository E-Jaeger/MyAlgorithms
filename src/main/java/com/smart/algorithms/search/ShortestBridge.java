package com.smart.algorithms.search;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/shortest-bridge/
 * 最短的桥
 */
public class ShortestBridge {

    public static int shortestBridge(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int res = 0;
        Deque<int[]> deque = new LinkedList<>();

        outer:
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (A[i][j] == 1) {
                    dfs(i, j, A, deque);
                    break outer;
                }
            }
        }
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int[] poll = deque.poll();
                int row = poll[0];
                int col = poll[1];
                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                        if (A[newRow][newCol] == 0) {
                            deque.offer(new int[]{newRow, newCol});
                            A[newRow][newCol] = 2;
                        } else if (A[newRow][newCol] == 1) {
                            return res;
                        }
                    }
                }
            }
            res++;
        }
        return -1;
    }

    private static void dfs(int i, int j, int[][] a, Deque<int[]> deque) {
        if (i < 0 || j < 0 || i >= a.length || j >= a[0].length || a[i][j] != 1) {
            return;
        }
        a[i][j] = 2;
        deque.offer(new int[]{i, j});
        dfs(i + 1, j, a, deque);
        dfs(i - 1, j, a, deque);
        dfs(i, j + 1, a, deque);
        dfs(i, j - 1, a, deque);
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{
                {0, 1, 0},
                {0, 0, 0},
                {0, 0, 1}
        };
        int i = shortestBridge(a);
        System.out.println(i);
    }
}
