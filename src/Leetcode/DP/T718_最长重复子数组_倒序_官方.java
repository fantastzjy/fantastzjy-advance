package Leetcode.DP;

//给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
public class T718_最长重复子数组_倒序_官方 {

    //思路 比较当前是否相等   当前相等则 在二维数组中 加上向前或向后移动后的结果（比较各自前一个位置是否相等）

    public int findLength(int[] A, int[] B) {
        int n = A.length, m = B.length;
        //+1 是因为做个底层，要让最后面比较的时候不用管越界
        int[][] dp = new int[n + 1][m + 1];
        int ans = 0;

        //倒序这个办法好 不用处理正序时 最上和最左初始化问题   直接利用 数组默认值为0的特性
        //长度是n、m  真正的边界元素是 n、m 减1  之后的结果    数组边界长度nm加1 虽然dp数组边界是nm
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1 : 0;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}