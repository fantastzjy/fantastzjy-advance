package Leetcode.DP;

public class T198_打家劫舍 {

    //拓展  不用备忘录  用两个变量

    public int rob(int[] nums) {

        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }

        int[] memo = new int[nums.length];
        memo[0] = nums[0];
        //从nums[1] 就要开始取和前面相比较的最大值了   由于他没法加前前一个，所以就是自己本身和前一个比较！！
        //这里相当于   memo[1] = Math.max(nums[1]+memo[1 - 2], memo[1-1]);    memo[1 - 2]越界了不写
        //memo[1] = nums[1];   错!!!!!
        memo[1] = Math.max(nums[1], memo[0]);    //！！！！！

        for (int i = 2; i < nums.length; i++) {
            //就是把和前一个相加和当前比较换成 和 前前一个相加和当前比较  每一个都是记录的当前的最大值
            //如果和前面的加起来都没当前的大的话
            // 每一个记录的都是当前的最大值 即 当前位置为止最大的不连续的值得总和
            // 如果是 取  nums[i] + memo[i - 2]  证明
            memo[i] = Math.max(nums[i] + memo[i - 2], memo[i - 1]);
        }
        return memo[nums.length - 1];
    }
    //空间复杂度：O(1)。使用滚动数组，可以只存储前两间房屋的最高总金额，而不需要存储整个数组的结果，因此空间复杂度是 O(1)O(1)。
    //链接：https://leetcode-cn.com/problems/house-robber/solution/da-jia-jie-she-by-leetcode-solution/
}
