package com.smart.algorithms.search;

/**
 * https://leetcode-cn.com/problems/surrounded-regions/
 * 被围绕的区域
 */
public class Solve {
    static int n, m;
    public static void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }
        n = board.length;
        m = board[0].length;
        for (int i = 0; i < n; i++) {
            dfs(i, 0, board);
            dfs(i, m - 1, board);
        }
        for (int i = 1; i < m - 1; i++) {
            dfs(0, i, board);
            dfs(n - 1, i, board);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

    }

    private static void dfs(int i, int j, char[][] board) {
        if (i < 0 || j < 0 || i >= n || j >= m || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'A';
        dfs(i + 1, j, board);
        dfs(i - 1, j, board);
        dfs(i, j + 1, board);
        dfs(i, j - 1, board);
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
        };
        solve(board);
        for (char[] chars : board) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(chars[j]);
            }
            System.out.println();
        }
    }
}
