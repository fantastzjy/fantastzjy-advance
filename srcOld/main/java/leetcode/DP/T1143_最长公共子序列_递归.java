package leetcode.DP;

import java.util.Arrays;

//子序不是连续的 保证相对顺序即可！！！！！！！
public class T1143_最长公共子序列_递归 {

    int[][] dp;
    int m;
    int n;

    public int longestCommonSubsequence(String text1, String text2) {
        dp = new int[m = text1.length()][n = text2.length()];
        //用于剪枝！！！！！
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        //i j =0 表示 从0 开始   这里的
        return longestCommonSubsequence(text1, 0, text2, 0);
    }

    private int longestCommonSubsequence(String text1, int i, String text2, int j) {
        //base
        if (m == i || n == j) {
            return 0;
        }

        //剪枝！！！
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (text1.charAt(i) == text2.charAt(j)) {
            dp[i][j] = 1 + longestCommonSubsequence(text1, i + 1, text2, j + 1);
        } else {
            dp[i][j] = Math.max(
                    longestCommonSubsequence(text1, i + 1, text2, j),
                    longestCommonSubsequence(text1, i, text2, j + 1));
        }
        return dp[i][j];
    }
}

