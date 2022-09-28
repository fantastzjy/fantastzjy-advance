package leetcode.DP;

import java.util.Arrays;

public class T322_零钱兑换_自顶向下递归法 {

    //可以把自己定义的公共数组 或者变量 放到最上面  在传参时就不用每次都去写了
    //题中方法中给的就不要写在最上面了

    //备忘录
    int[] dp;

    public int coinChange(int[] coins, int amount) {

        if (amount < 0) {
            return -1;
        }
        //0的话就不用凑了 下面循环里一减就是负数
        if (amount == 0) {
            return 0;
        }
        dp = new int[amount + 1];
        //初始化数组
        Arrays.fill(dp,-666);

        //int res = count(coins, amount);
        //if (res == -1) {
        //    return -1;
        //} else {
        //
        //    return res;
        //}
        //上面几行是废话  直接就是res嘛

        return count(coins, amount);
    }


    private int count(int[] coins, int amount) {

        //定义base
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        //查看备忘录 防止重复计算   查看备忘录的操作要在检查参数之后 不然数组会越界
        if (dp[amount] != -666) {
            return dp[amount];
        }

        int res = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            //计算子问题的结果
            int subProblem = count(coins, amount - coins[i]);
            //子问题无解则跳过  表示这个amount - coins[i]  越界base返回的-1
            if (subProblem == -1) {
                continue;
            }
            //在子问题中选择最优解 然后加1   这里的 1 是表示amount - coins[i] 这个 ‘硬币’
            //rs和每一轮的值都会比较一下
            res = Math.min(res, 1 + subProblem);
        }

        //if (res == -1) {
        //    return -1;
        //} else {
        //    dp[amount] = res;
        //    return res;
        //}
        // 把计算结果 存入备忘录    如果结果是-1 或者 最大值（如果全是-1的话 res是maxvalue） 也要存进去 因为表示行不通
        dp[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
        return dp[amount];
    }

}
