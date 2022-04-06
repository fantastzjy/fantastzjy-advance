package Leetcode.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T51_N皇后 {
    List<List<String>> res = new ArrayList<>();
    int n;

    public static void main(String[] args) {
        List<List<String>> lists = new T51_N皇后().solveNQueens(4);
        System.out.println(lists.get(0));
    }


    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[0], '.');
        }
        backtrack(board, 0);

        return res;
    }

    public void backtrack(char[][] board, int row) {
        //if (board[row].length == n) {
        if (row == n) {
            ArrayList<String> strings = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(board[i]);
                strings.add(sb.toString());
            }
            res.add(new ArrayList<>(strings));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!isValid(board, col, row)) {
                continue;
            }
            board[row][col] = 'Q';
            backtrack(board, row + 1);
            board[row][col] = '.';
        }
    }


    public boolean isValid(char[][] board, int row, int col) {
        if ((row - 1) >= 0 && (col - 1) >= 0 && board[row - 1][col - 1] == 'Q') {
            return false;
        }
        if ((row - 1) >= 0 && board[row - 1][col] == 'Q') {
            return false;
        }
        if ((row - 1) >= 0 && (col + 1) <= col && board[row - 1][col + 1] == 'Q') {
            return false;
        }
        return true;
    }
}
