package leetcode.DP;

public class T55_跳跃游戏_自后向前_ {


    public boolean canJump2(int[] nums) {

        int len = nums.length;


        int[] dp = new int[len];

        for (int i = len - 2; i >= 0; i--) {

            int max = Math.max(nums[i] + i, len - 1);

            for (int j = i + 1; j <= max; j++) {

                if (dp[j] == 1) {
                    dp[i] = 1;
                    break;
                }
            }


        }


        return true;
    }
}
