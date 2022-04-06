package Leetcode.DP;

public class T62_不同路径 {

    //注意 ：机器人每次只能向下或者向右移动一步。
    //动态规划  用二维数组记忆化小技巧   将第一行第一列先计算出来手动填充上


    public int uniquePaths(int m, int n) {
        int[][] ints = new int[m][n];
        for (int i = 0; i < m; i++) {
            ints[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            ints[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                ints[i][j] = ints[i - 1][j] + ints[i][j - 1];
            }
        }

        //里面不是mn 不要越界啦
        return ints[m - 1][n - 1];
    }
    //时间复杂度：O(mn)
    //空间复杂度：O(mn)，即为存储所有状态需要的空间。注意到 f(i, j)f(i,j) 仅与第 ii 行和第 i-1i−1 行的状态有关，因此我们可以使用滚动数组代替代码中的二维数组，使空间复杂度降低为 O(n)O(n)。此外，由于我们交换行列的值并不会对答案产生影响，因此我们总可以通过交换 mm 和 nn 使得 m \leq nm≤n，这样空间复杂度降低至 O(\min(m, n))O(min(m,n))。

    //链接：https://leetcode-cn.com/problems/unique-paths/solution/bu-tong-lu-jing-by-leetcode-solution-hzjf/

}
