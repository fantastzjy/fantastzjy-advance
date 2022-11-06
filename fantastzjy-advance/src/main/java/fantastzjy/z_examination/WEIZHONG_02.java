package fantastzjy.z_examination;

import java.util.Scanner;

//只过了64
//数组的xy与坐标系的xy弄混了

public class WEIZHONG_02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        String s = sc.next();
        int len = s.length();

        int sum = 0;
        int xx = 0, yy = 0;

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);

            //方向改变
            if (i > 0 && s.charAt(i - 1) != ch) {
                sum += x;
            }
            //左
            if (ch == 'h') {
                if (yy - 1 >= 0 && arr[xx][yy - 1] == -1) {
                    sum += y;
                } else if (yy - 1 >= 0) {
                    yy--;
                    sum = sum + Math.max(arr[xx][yy], arr[xx][yy + 1]);
                } else {
                    sum += y;
                }
            }
            //右
            else if (ch == 'l') {
                if (yy + 1 < m && arr[xx][yy + 1] == -1) {
                    sum += y;
                } else if (yy + 1 < m) {
                    yy++;
                    sum = sum + Math.max(arr[xx][yy], arr[xx][yy - 1]);
                } else {
                    sum += y;
                }
            }
            //下
            else if (ch == 'j') {
                if (xx + 1 < n && arr[xx + 1][yy] == -1) {
                    sum += y;
                } else if (xx + 1 < n) {
                    xx++;
                    sum = sum + Math.max(arr[xx][yy], arr[xx - 1][yy]);
                } else {
                    sum += y;
                }
            }
            //上
            else if (ch == 'k') {
                if (xx - 1 >= 0 && arr[xx - 1][yy] == -1) {
                    sum += y;
                } else if (xx - 1 >= 0) {
                    xx--;
                    sum = sum + Math.max(arr[xx][yy], arr[xx + 1][yy]);
                } else {
                    sum += y;
                }
            }


        }
        System.out.println(sum);

    }


}

