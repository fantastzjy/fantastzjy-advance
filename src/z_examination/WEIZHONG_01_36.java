package z_examination;

import java.util.Scanner;

public class WEIZHONG_01_36 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            int v = arr[i];
            boolean ha = true;
            boolean ha2 = false;
            for (int j = 1; j <= v; j++) {
                if (j * j * j >= v) {
                    //System.out.println("NO");
                    ha = false;
                    break;
                }
                for (int k = 1; k <= v; k++) {
                    if (j * j * j + k * k * k * k >= v) {
                        //System.out.println("NO");
                        ha = false;
                        break;
                    }

                    for (int l = 1; l <= v; l++) {
                        if (j * j * j + k * k * k * k + l * l * l * l * l == v) {
                            System.out.println("YES");
                            ha2 = true;
                            break;
                        }
                    }
                }


            }
            if (ha == false && ha2 == false) {
                System.out.println("NO");
            }
        }


    }


}

