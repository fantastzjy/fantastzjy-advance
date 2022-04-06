package Leetcode.DP;

//https://leetcode-cn.com/problems/house-robber-ii/
public class T213_打家劫舍II {
    //题：所有的房屋都 围成一圈

    //思路：三种情况 选择头   选择尾   都不选

    public int rob(int[] nums) {
        //base
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(
                subRob(nums, 0, nums.length - 2),
                subRob(nums, 1, nums.length - 1)
        );
    }

    private int subRob(int[] nums, int l, int r) {

        int v1 = 0;
        int v2 = 0;
        int v = 0;

        //v1 = nums[l];
        //v2 = Math.max(nums[l + 1], nums[l]);


        for (int i = r; i >= l; i--) {
            v = Math.max(nums[i] + v2, v1);

            v2 = v1;
            v1 = v;
        }
        return v;
    }

}
