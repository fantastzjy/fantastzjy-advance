package leetcode.dp;

public class T55_跳跃游戏 {

    //最下面的贪心算法最快

    //dp方法 时间复杂度太大吧  用下面的贪心比较好

    //top方法 自顶向下   由于递归深度比较大  时间复杂度很高
    public boolean canJump(int[] nums) {
        int length = nums.length;
        //存储数组
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


    //bom方法 从后往前   没有了递归  时间是原来的  1/6
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

        //只看第一个是否为1  就是看是走到第一个并走通了
        if (memo[0] == 1) {
            return true;
        } else {
            return false;
        }


    }


    //贪心算法    利用当前位置 加上最大能跳跃的位置 看坐标是否能大于等于下一个位置
    public boolean canJump3(int[] nums) {
        int maxJump = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {

            if (nums[i] + i >= maxJump) {
                maxJump = i;
            }

        }
        //if (maxJump ==0 ) {
        //    return true;
        //} else {
        //    return false;
        //}
        //合并
        return maxJump == 0;
    }


}
