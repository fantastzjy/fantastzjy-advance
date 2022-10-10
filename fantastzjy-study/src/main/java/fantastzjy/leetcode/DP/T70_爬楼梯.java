package fantastzjy.leetcode.DP;

public class T70_爬楼梯 {

    //要么是跨一步到该阶要么是两步  那走到这里不会就是、、、、

    //先观察规律在做题
    //第三个等于前两个路线方法总和
    public int climbStairs(int n) {
        int first = 0;
        int second = 1;
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = first + second;
            first = second;
            second = res;
        }

        return res;
    }

    //链接：https://leetcode-cn.com/problems/climbing-stairs/solution/pa-lou-ti-by-leetcode-solution/

}