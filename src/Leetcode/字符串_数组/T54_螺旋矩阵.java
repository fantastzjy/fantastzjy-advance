package Leetcode.字符串_数组;

import java.util.ArrayList;
import java.util.List;

//方法二：按层模拟
//时间复杂度：O(mn)，其中 m 和 n 分别是输入矩阵的行数和列数。矩阵中的每个元素都要被访问一次。
//空间复杂度：O(1)。除了输出数组以外，空间复杂度是常数。
//链接：https://leetcode-cn.com/problems/spiral-matrix/solution/luo-xuan-ju-zhen-by-leetcode-solution/
public class T54_螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {

        ArrayList<Integer> res = new ArrayList<>();

        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        String dir = "right";
        //巧妙标志方向控制方向
        //利用  利用左右边界是否重叠 判断是否遍历完  如果不是等于的话最后中心那些遍历不完
        while (left <= right && up <= down) {
            if (dir.equals("right")) {
                for (int i = left; i <= right; i++) {
                    res.add(matrix[up][i]);
                }
                up++;
                dir = "down";
            } else if (dir.equals("down")) {
                for (int i = up; i <= down; i++) {
                    res.add(matrix[i][right]);
                }
                right--;
                dir = "left";
            } else if (dir.equals("left")) {
                for (int i = right; i >= left; i--) {
                    res.add(matrix[down][i]);
                }
                down--;
                dir = "up";
            } else if (dir.equals("up")) {
                for (int i = down; i >= up; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
                dir = "right";
            }
        }
        return res;
    }
}