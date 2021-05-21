package leetcode.dp;

public class T198_打家劫舍 {
    public int rob(int[] nums) {

        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }

        int[] memo=new int[nums.length];
        memo[0] = nums[0];
        //memo[1] = nums[1];  从nums[1] 就要开始取和前面相比较的最大值了
        //memo[1] = Math.max(nums[1],nums[1]+memo[0]);
        memo[1] = Math.max(nums[1],memo[0]);    //如果是nums[1]+memo[0] 就违反规则了

        for (int i = 2; i <nums.length ; i++) {
            memo[i]= Math.max(nums[i] + memo[i - 2], memo[i - 1]);

        }
        return memo[nums.length - 1];

    }

    //时间复杂度：O(n)O(n)，其中 nn 是数组长度。只需要对数组遍历一次。
    //
    //空间复杂度：O(1)O(1)。使用滚动数组，可以只存储前两间房屋的最高总金额，而不需要存储整个数组的结果，因此空间复杂度是 O(1)O(1)。
    //
    //作者：LeetCode-Solution
    //链接：https://leetcode-cn.com/problems/house-robber/solution/da-jia-jie-she-by-leetcode-solution/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



}
