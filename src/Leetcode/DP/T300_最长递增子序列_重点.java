package Leetcode.DP;

public class T300_最长递增子序列_重点 {

    public int lengthOfLIS(int[] nums) {
        //basecase和dp[0] max = 1; 一定要写！！！
        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            //!!!!每一个的本身长度是一 写在这里不用再单独遍历一遍赋值   而dp[0] 单独写下比较好
            dp[i] = 1;
            //从头向后遍历 如果大于他就 比较下看用不用更新
            //并不是找到第一个大于的 就停止  前面可能还有更大的连续的  只是第一个不大于他
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-by-leetcode-soluti/