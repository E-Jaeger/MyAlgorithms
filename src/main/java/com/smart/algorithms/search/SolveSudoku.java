package com.smart.algorithms.search;

/**
 * https://leetcode-cn.com/problems/sudoku-solver/
 * 解数独
 */
public class SolveSudoku {

    public static void solveSudoku(char[][] board) {
        if (board.length == 0) {
            return;
        }
        dfs(board, 0, 0);
    }

    //注意这里的参数，row表示第几行，col表示第几列。
    private static boolean dfs(char[][] board, int row, int col) {
        //最后一行全部读遍历完了，说明数独中的值是有效的，直接返回true
        if (row == board.length)
            return true;
        //如果当前行的最后一列也遍历完了，就从下一行的第一列开始。这里的遍历
        //顺序是从第1行的第1列一直到最后一列，然后第二行的第一列一直到最后
        //一列，然后第三行的……
        if (col == board.length)
            return dfs(board, row + 1, 0);
        //如果当前位置已经有数字了，就不能再填了，直接到这一行的下一列
        if (board[row][col] != '.')
            return dfs(board, row, col + 1);
        //如果上面条件都不满足，我们就从1到9种选择一个合适的数字填入到数独中
        for (char i = '1'; i <= '9'; i++) {
            //判断当前位置[row，col]是否可以放数字i，如果不能放再判断下
            //一个能不能放，直到找到能放的为止，如果从1-9都不能放，就会下面
            //直接return false
            if (!valid(board, row, col, i))
                continue;
            //如果能放数字i，就把数字i放进去
            board[row][col] = i;
            //如果成功就直接返回，不需要再尝试了
            if (dfs(board, row, col))
                return true;
            //否则就撤销重新选择
            board[row][col] = '.';
        }
        //如果当前位置[row，col]不能放任何数字，直接返回false
        return false;
    }

    //验证当前位置[row，col]是否可以存放字符c
    private static boolean valid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            //当前列有没有和字符c重复的
            if (board[i][col] == c)
                return false;
            //当前行有没有和字符c重复的
            if (board[row][i] == c)
                return false;
            //当前的单元格内是否有和字符c重复的
            //row=4 col=4 i=6 board[5][3]
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
                return false;
        }
        return true;
    }

    public static void printBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solveSudoku(board);
        printBoard(board);
    }
}
