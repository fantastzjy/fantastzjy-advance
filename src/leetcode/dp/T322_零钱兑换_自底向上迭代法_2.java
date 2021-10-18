package leetcode.dp;

public class T322_零钱兑换_自底向上迭代法_2 {


    public int coinChange(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }

        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        //return dp[amount+1];
        return (dp[amount] != amount + 1) ? dp[amount] : -1;
    }


}
