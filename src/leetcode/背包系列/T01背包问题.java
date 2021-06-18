package leetcode.背包系列;

//动态规划套路   1、状态+选择    2、定义dp数组   3、根据选择思考状态转移逻辑
public class T01背包问题 {

    public int knapsack(int W, int N, int[] wt, int[] val) {
        //basecase

        //定义dp数组
        //后面边界要加1  因为定义得意思是 实际的物品就是N个 实际的重量就是 W
        int[][] dp = new int[N + 1][W + 1];

        //明确状态 一个是 装几个东西  一个是 重量装多重


        //为什么不加入的时候让 dp[n][w] = dp[n - 1][w]呢 ？？？？？
        // 因为当填入n-1个物品的时候 会循环到w重量 所以dp[n - 1][w]已经有值了
        //注意边界和角标
        for (int n = 1; n <= N; n++) {
            for (int w = 2; w <= W; w++) {
                if (w - wt[w - 1] < 0) {
                    dp[n][w] = dp[n - 1][w];
                } else {
                    dp[n][w] = Math.max(dp[n - 1][w - wt[w - 1]] + val[n - 1]
                            , dp[n][w] = dp[n - 1][w]);
                }
            }
        }

        //注意角标
        return dp[N][W];
    }
}
