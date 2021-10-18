package leetcode.dp;

public class T300_最长递增子序列_2 {

    public int lengthOfLIS(int[] nums) {

        if (nums.length == 1) {
            return 1;
        }
        //最大值初始化为1 如果全部都相同 则为1 而不是0
        int max = 1;

        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    //把这个放在内循环的额外面比较比较好
                    //if (max < dp[i]) {
                    //    max = dp[i];
                    //}
                }
            }
            if (max < dp[i]) {
                max = dp[i];
            }

        }

        return max;
    }
}

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-by-leetcode-soluti/