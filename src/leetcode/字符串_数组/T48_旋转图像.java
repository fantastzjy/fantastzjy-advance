package leetcode.字符串_数组;


//解析见labuladong  https://labuladong.gitee.io/algo/2/19/24/
public class T48_旋转图像 {

    public void rotate(int[][] matrix) {

        int n = matrix.length;
        //左上到右下对角线旋转
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        //左右对称翻转      修改值会影响到原数组！！！！！！！
        for (int[] ints : matrix) {
            int l = 0;
            int r = ints.length - 1;

            while (l < r) {
                int tmp = ints[l];
                ints[l] = ints[r];
                ints[r] = tmp;
                l++;
                r--;
            }

        }

    }


    class T旋转矩阵_辅助数组 {
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            int[][] matrix_new = new int[n][n];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    matrix_new[j][n - i - 1] = matrix[i][j];
                }
            }
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    matrix[i][j] = matrix_new[i][j];
                }
            }
        }
    }

    class T旋转矩阵_原地旋转_二维数组的边界处理比较好 {
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

}