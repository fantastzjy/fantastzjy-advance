package leetcode.DP;

public class T55_跳跃游戏_自后向前 {
    //最下面的贪心算法最快
    //dp方法 时间复杂度太大吧  用下面的贪心比较好
    //top方法 自顶向下   由于递归深度比较大  时间复杂度很高

    //bom方法 自底向上   没有了递归  时间是原来的  1/6
    public boolean canJump2(int[] nums) {
        int length = nums.length;
        //存储数组
        int[] memo = new int[length];
        //标记最后一个为可通过
        memo[length - 1] = 1;

        //从后往前 再往后遍历 看是否能遇到标记为1的 能遇到就是能跳到  不用递归了
        for (int i = nums.length - 2; i >= 0; i--) {
            //防止右边越界！！！！
            int maxJump = Math.min(i + nums[i], nums.length - 1);
            // 若步长范围内有已经标记为可到达的点  则该点也可到达！
            //步长范围内没有1 的话 ，当遍历到最前面 会是0
            for (int j = i + 1; j <= maxJump; j++) {
                if (memo[j] == 1) {
                    memo[i] = 1;
                    break;
                }
            }
        }

        //只看第一个是否为1 即可
        return memo[0] == 1;
    }
}
