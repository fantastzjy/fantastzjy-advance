package fantastzjy.leetcode.字符串_数组;

import java.util.ArrayList;
import java.util.List;

//https://labuladong.gitee.io/algo/2/19/24/
public class T54_螺旋矩阵_labuladong {
    public List<Integer> spiralOrder(int[][] matrix) {

        ArrayList<Integer> res = new ArrayList<>();

        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        //!!!!  数量不够就继续遍历     后边是实际的长和宽    体题中没说是多是等宽！！！
        while (res.size() < matrix.length * matrix[0].length) {

            //确保这一行 存在
            if (up <= down) {
                int index = left;
                while (index <= right) {
                    res.add(matrix[up][index++]);
                }
                up++;
            }
            if (right >= left) {
                int index = up;
                while (index <= down) {
                    res.add(matrix[index++][right]);
                }
                right--;
            }
            if (up <= down) {
                int index = right;
                while (index >= left) {
                    res.add(matrix[down][index--]);
                }
                down--;
            }
            if (right >= left) {
                int index = down;
                while (index >= up) {
                    res.add(matrix[index--][left]);
                }
                left++;
            }
        }
        return res;
    }
}