package leetcode.dp;

import java.util.Arrays;

public class T322_零钱兑换_自底向上迭代法 {


    public int coinChange(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }

        int[] dp = new int[amount + 1];
        //初始化数组   初始值不能是最大值 +1 后会越界  -2147483648
        Arrays.fill(dp, amount + 1);
        //一定要进行赋值   不赋值的话 求的 1 就会是定义的最大值  后面的好几个都会是最大值
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                //直接赋值给dp[i]即可
                //min = Math.min(dp[i], dp[i - coin]);
                //如果dp[i - coin] 不能凑出 dp[i]会等于  amount + 1   最后判断是否等于 amount + 1 看有没有解
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
            //dp[i] = (min != dp[i]) ? min : dp[i];
        }

        return (dp[amount] != amount + 1) ? dp[amount] : -1;
    }


}
