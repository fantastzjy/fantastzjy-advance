package 笔试;

import java.util.Scanner;

public class baidu_1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            //arr[i] = sc.nextInt();
            // sc.nextInt()%100;
            int j = sc.nextInt();
            if (400 <= j && j <= 499) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }


    }

}
