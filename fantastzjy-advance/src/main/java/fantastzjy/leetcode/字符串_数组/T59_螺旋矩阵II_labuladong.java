package fantastzjy.leetcode.字符串_数组;

//labuladong
public class T59_螺旋矩阵II_labuladong {
    public int[][] generateMatrix(int n) {


        int[][] matrix = new int[n][n];
        int res = 1;

        int up = 0;
        int down = n - 1;
        int left = 0;
        int right = n - 1;

        //!!!!  数量不够就继续遍历     后边是实际的长和宽    体题中没说是多是等宽！！！
        while (res <= n * n) {

            //确保这一行 存在
            if (up <= down) {
                int index = left;
                while (index <= right) {

                    matrix[up][index++] = res++;
                }
                up++;
            }
            if (right >= left) {
                int index = up;
                while (index <= down) {
                    matrix[index++][right] = res++;
                }
                right--;
            }
            if (up <= down) {
                int index = right;
                while (index >= left) {
                    matrix[down][index--] = res++;
                }
                down--;
            }
            if (right >= left) {
                int index = down;
                while (index >= up) {
                    matrix[index--][left] = res++;
                }
                left++;
            }
        }

        return matrix;

    }

}


//链接：https://leetcode-cn.com/problems/spiral-matrix-ii/solution/luo-xuan-ju-zhen-ii-by-leetcode-solution-f7fp/
