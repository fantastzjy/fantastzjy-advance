package leetcode.DP;

public class T55_跳跃游戏_贪心算法 {

    //最下面的贪心算法最快
    //dp方法 时间复杂度太大吧  用下面的贪心比较好
    //top方法 自顶向下   由于递归深度比较大  时间复杂度很高

    //贪心算法
    //利用当前位置 加上最大能跳跃的位置 看坐标是否能大于等于下一个位置
    //中间有不大于的没关系  只要前面有超过maxJump的  就能更新maxJump   如果最后更新到0就带边通过
    public boolean canJump3(int[] nums) {
        int maxJump = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] + i >= maxJump) {
                maxJump = i;
            }
        }

        //合并
        return maxJump == 0;
    }
}
