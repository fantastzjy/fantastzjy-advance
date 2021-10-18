package leetcode.dp;

import java.util.Arrays;

//子序不是连续的 保证相对顺序即可！！！！！！！
public class T1143_2 {

    int[][] dp;
    int m = 0;
    int n = 0;

    public int longestCommonSubsequence(String text1, String text2) {
        m = text1.length();
        n = text2.length();
        if (m == 0 || n == 0) {
            return 0;
        }
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return longest(text1, 0, text2, 0);
    }

    private int longest(String text1, int i, String text2, int j) {

        if (i == m || j == n) {
            return 0;
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            dp[i][j] = 1 + longest(text1, i + 1, text2, j + 1);
        } else {
            dp[i][j] = Math.max(
                    (longest(text1, i + 1, text2, j)),
                    longest(text1, i, text2, j + 1));
        }

        return dp[i][j];

    }
}

