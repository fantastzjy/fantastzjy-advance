package leetcode.DP;

public class T198_打家劫舍_ {
    public int rob(int[] nums) {

        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        //dp[1] = nums[1];    注意理解
        dp[1] = Math.max(nums[1], dp[0]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[dp.length - 1];
    }
}
