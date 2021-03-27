package com.smart.algorithms.search;

/**
 * https://leetcode-cn.com/problems/word-search/
 * 单词搜索
 */
public class WordSearch {

    public static boolean exist(char[][] board, String word) {
        if (board.length == 0) {
            return false;
        }
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(i, j, words, board, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(int i, int j, char[] words, char[][] board, int index) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || words[index] != board[i][j]) {
            return false;
        }
        if (index == words.length - 1) {
            return true;
        }
        char tmp = board[i][j];
        board[i][j] = '.';
        boolean res = dfs(i + 1, j, words, board, index + 1) ||
                dfs(i - 1, j, words, board, index + 1) ||
                dfs(i, j + 1, words, board, index + 1) ||
                dfs(i, j - 1, words, board, index + 1);
        board[i][j] = tmp;
        return res;
    }

    public static void main(String[] args) {
        char[][] b = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(exist(b, "ABCCED"));
        System.out.println(exist(b, "SEE"));
        System.out.println(exist(b, "ABCB"));
    }

}
