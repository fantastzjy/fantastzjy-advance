package leetcode.DP;

//子序不是连续的 保证相对顺序即可！！！！！！！
public class T1143_最长公共子序列_dp {


    //妙啊  这个思想！
    // 让从1开始还可以同时还可以避免前面越界的问题

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j - 1);

                //若相等则 1+左上角的值
                //若不相等则左边或上边的值    所以若不相等  则记录的是之前相等时的子序列的长度！！！！！！
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
