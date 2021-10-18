package leetcode.dp;

public class T55_跳跃游戏_自前向后_递归思想 {

    //贪心算法最快
    //dp 时间复杂度太大  用下面的贪心比较好

    //top方法 自顶向下   由于递归深度比较大  时间复杂度很高！！！
    public boolean canJump(int[] nums) {
        int length = nums.length;
        int[] memo = new int[length];

        //标记最后一个为可通过
        memo[length - 1] = 1;
        boolean jump = jump(nums, memo, 0);
        return jump;
    }

    private boolean jump(int[] nums, int[] memo, int position) {
        if (memo[position] == 1) {
            return true;
        } else if (memo[position] == -1) {
            return false;
        }

        //最大跳跃部步数  不是直接加上步数 防止数组越界 确保最大只能到length-1
        //用position 最终还是抵消了
        //maxJump 能够到的最大位置（具体
        //注意是最小值不只是最大值 如果能跳跃的步数大于长度 就取长度的位置
        int maxJump = Math.min(position + nums[position], nums.length - 1);
        //注意起始终止位置
        for (int i = position + 1; i <= maxJump; i++) {
            boolean jumpResult = jump(nums, memo, i);
            //只要有一条路通就标记为1
            if (jumpResult) {
                memo[position] = 1;
                return true;
            }
        }
        //如果把能跳的几部都走完了还是不行 就标记为-1
        memo[position] = -1;
        return false;
    }

}
