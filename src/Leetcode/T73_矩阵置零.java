package Leetcode;

public class T73_矩阵置零 {

    //这种题的核心思想就是  做标记 可以用第一行第一列去做标记
    // 可以生成亮哥哥boolean数组做标记


    public void setZeroes(int[][] matrix) {
        boolean firstcol = false;
        boolean firstrow = false;


        //检查第一行和第一列是否为0并做好标记
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                firstcol = true;
                //break;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            //if (matrix[i][0] == 0) {    小错酿成大错   一定要用col和row标注
            if (matrix[0][i] == 0) {
                firstrow = true;
                //break;
            }
        }

        //遍历 使用第一行和第一列来标记是否有0
        //注意这里要跳过第0行第0列
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //用第一行和第一列为0的情况  将矩阵置0
        //注意这里要跳过第0行第0列
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        //处理第一列有0的情况
        if (firstcol) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        //处理第一行有0的情况
        if (firstrow) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }


    }


    //这个方法写着巨快   但是牺牲了空间 相比较方法一 方法一如果要求空间复杂度O（1） 则更好
    public void setZeroes2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    //作者：LeetCode-Solution
    //链接：https://leetcode-cn.com/problems/set-matrix-zeroes/solution/ju-zhen-zhi-ling-by-leetcode-solution-9ll7/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

}
