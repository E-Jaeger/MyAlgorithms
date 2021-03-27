package com.smart.algorithms.search;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-queens/
 * N 皇后
 */
public class SolveNQueens {

    public static List<List<String>> solveNQueens(int n) {
        char[][] chess = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chess[i][j] = '.';
            }
        }
        List<List<String>> res = new LinkedList<>();
        dfs(chess, 0, res);
        return res;
    }

    private static void dfs(char[][] chess, int row, List<List<String>> res) {
        if (row == chess.length) {
            res.add(construct(chess));
            return;
        }
        for (int col = 0; col < chess[0].length; col++) {
            if (valid(chess, row, col)) {
                chess[row][col] = 'Q';
                dfs(chess, row + 1, res);
                chess[row][col] = '.';
            }
        }
    }

    private static boolean valid(char[][] chess, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (chess[i][col] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess[0].length; i--, j++) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private static List<String> construct(char[][] chess) {
        List<String> res = new LinkedList<>();
        for (char[] chars : chess) {
            res.add(new String(chars));
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<String>> lists = solveNQueens(4);
        System.out.println(lists);
    }
}
