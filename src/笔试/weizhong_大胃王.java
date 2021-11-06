package 笔试;

import java.util.Scanner;

public class weizhong_大胃王 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[] arr = new char[N];
        int[] ints = new int[N];

        for (int i = 0; i < N; i++) {
            String[] strs = sc.nextLine().trim().split("\\s+");
            sc.nextLine();
            arr[i] = strs[0].charAt(0);

            if (arr[i] == 's' || arr[i] == 'n') {
                continue;
            }

            ints[i] = strs[1].charAt(0) - '0';
        }


        int[][] dp = new int[N][N];
        int[][] groups = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                groups[i][j] = sc.nextInt();
            }
        }
/*
3
+2
n
/ 2
- 5
s
 */
    }
}