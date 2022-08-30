package leetcode.DP;

import java.util.Arrays;

public class T322_零钱兑换_自底向上迭代法_2 {


    public int coinChange(int[] coins, int amount) {

        if (coins == null || coins.length < 1) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] != amount + 1 ? dp[amount] : -1;
    }

}
