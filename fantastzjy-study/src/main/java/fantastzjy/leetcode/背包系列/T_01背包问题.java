package fantastzjy.leetcode.背包系列;

//动态规划套路   1、状态+选择    2、定义dp数组   3、根据选择思考状态转移逻辑
public class T_01背包问题 {

    public int knapsack(int W, int N, int[] wt, int[] val) {
        //明确状态 一个是 装几个东西  一个是 背包容量
        int[][] dp = new int[N + 1][W + 1];

        //basecase
        for (int i = 0; i < W; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i < N; i++) {
            dp[i][0] = 0;
        }

        for (int n = 1; n <= N; n++) {
            for (int w = 1; w <= W; w++) {
                if (w - wt[n - 1] < 0) {
                    dp[n][w] = dp[n - 1][w];
                } else {
                    dp[n][w] = Math.max(dp[n - 1][w - wt[n - 1]] + val[n - 1], dp[n - 1][w]);
                }
            }
        }
        return dp[N][W];
    }
}
