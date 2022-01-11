package leetcode.字符串_数组;

//方法二 原地旋转
//时间复杂度：O(N^2)，
//空间复杂度：O(1)。为原地旋转。
public class T旋转矩阵_原地旋转_二维数组的边界处理比较好 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //两层循环 圈定上三角
        //找一个点 确定他们的位置
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < (n + 1) / 2; ++j) {

                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }
}

//  https://leetcode-cn.com/problems/rotate-matrix-lcci/solution/xuan-zhuan-ju-zhen-by-leetcode-solution/
