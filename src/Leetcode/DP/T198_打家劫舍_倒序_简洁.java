package Leetcode.DP;

public class T198_打家劫舍_倒序_简洁 {
    public int rob(int[] nums) {

        int v = 0;
        int v1 = 0;
        int v2 = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            v = Math.max(nums[i] + v2, v1);
            v2 = v1;
            v1 = v;
        }
        return v;
    }
}