package Leetcode.DP;


public class T53_最大子序和 {


    //动态规划
    public int maxSubArray(int[] nums) {

        //int[] dp = new int[nums.length];
        //dp[0] = nums[0];   不用记忆化数组就行 直接原数组操作！！！

        //最大值的赋值 先设为数组的第一个数  不能自己瞎设
        int max = nums[0];

        //对数组进行遍历  比较前面之加上当前值大还是就要当前值大  将大的值存入数组
        //如果不存入数组 就会导致nums[i] + nums[i - 1]  仅仅是和前一个值得和
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i], nums[i] + nums[i - 1]);
            max = nums[i] > max ? nums[i] : max;
        }
        return max;
    }
}