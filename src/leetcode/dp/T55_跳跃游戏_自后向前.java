package leetcode.dp;

public class T55_跳跃游戏_自后向前 {
    //最下面的贪心算法最快
    //dp方法 时间复杂度太大吧  用下面的贪心比较好
    //top方法 自顶向下   由于递归深度比较大  时间复杂度很高

    //bom方法 自底向上   没有了递归  时间是原来的  1/6
    public boolean canJump2(int[] nums) {
        int length = nums.length;
        //存储数组   指定长度之后不用初始化 默认为0
        int[] memo = new int[length];
        //标记最后一个为可通过
        memo[length - 1] = 1;

        //从后往前 再往后遍历 看是否能遇到标记为1的 能遇到就是能跳到  不用递归了
        for (int i = nums.length - 2; i >= 0; i--) {
            int maxJump = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1; j <= maxJump; j++) {   //如果最大步数是0的话 i+1 就大于了最大能走到的位置 i + nums[i] 还是原位置
                if (memo[j] == 1) {
                    memo[i] = 1;
                    break;
                }
            }
        }

        //只看第一个是否为1  就是看是走到第一个并走通了！！！
        //if (memo[0] == 1) {
        //    return true;
        //} else {
        //    return false;
        //}
        return memo[0] == 1;
    }
}
