package Leetcode.字符串_数组;

public class T62_不同路径 {
    //dp解法  这也叫动态规划！！！噗
    public int uniquePaths(int m, int n) {

        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            //arr[i][0] = i;
            arr[i][0] = 1;//最左边和最上面都是只有一条路径所以 赋初始值为1
        }
        for (int i = 0; i < n; i++) {
            //arr[0][i] = i;
            arr[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
            }
        }

        return arr[m - 1][n - 1];

    }
}