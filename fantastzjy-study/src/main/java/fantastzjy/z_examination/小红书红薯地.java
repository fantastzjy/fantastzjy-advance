package fantastzjy.z_examination;

import java.util.Scanner;

public class 小红书红薯地 {


    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] arr = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int MAX = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int max = 0;
                if (in(m, n, i - 1, j)) {
                    int v1 = arr[i - 1][j];
                    max = Math.max(max, v1);
                }
                if (in(m, n, i - 1, j - 1)) {
                    int v2 = arr[i - 1][j - 1];
                    max = Math.max(max, v2);
                }
                if (in(m, n, i - 1, j + 1)) {
                    int v3 = arr[i - 1][j + 1];
                    max = Math.max(max, v3);
                }


                arr[i][j] += max;

                MAX = MAX < arr[i][j] ? arr[i][j] : MAX;
            }


        }


        System.out.println(MAX);


    }

    private static boolean in(int m, int n, int i, int j) {

        if (i < 0 || j < 0 || i >= m || j >= n) {
            return false;
        }


        return true;
    }


}
