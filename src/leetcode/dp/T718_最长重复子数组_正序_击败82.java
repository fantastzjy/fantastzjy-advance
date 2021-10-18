package leetcode.dp;

public class T718_最长重复子数组_正序_击败82 {
    public int findLength(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int[][] dp = new int[m][n];
        int ans = 0;

        //防止数组越界 让最左边和最上边先判断
        for (int i = 0; i < n; i++) {
            if (A[0] == B[i]) {
                dp[0][i] = 1;
                ans = 1;
            }
            if (A[i] == B[0]) {
                dp[i][0] = 1;
                ans = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = A[i] == B[j] ? dp[i - 1][j - 1] + 1 : 0;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}