package leetcode.dp;

public class T70_爬楼梯 {

    //先观察规律在做题
    //第三个等于前两个路线方法总和
    public int climbStairs(int n) {
        int first = 0;
        int second = 1;
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = first + second;
            first = second;
            second = max;

        }

        return max;
    }

    //复杂度分析
    //时间复杂度：循环执行 n 次，每次花费常数的时间代价，故渐进时间复杂度为 O(n)。
    //空间复杂度：这里只用了常数个变量作为辅助空间，故渐进空间复杂度为O(1)。
    //作者：LeetCode-Solution
    //链接：https://leetcode-cn.com/problems/climbing-stairs/solution/pa-lou-ti-by-leetcode-solution/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

}