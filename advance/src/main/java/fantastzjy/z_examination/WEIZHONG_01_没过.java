package fantastzjy.z_examination;

import java.util.Scanner;

public class WEIZHONG_01_没过 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            int v = arr[i];
            boolean chao = true;
            boolean yes = false;
            for (int j = 1; j <= v && chao == false; j++) {
                int jj = j * j * j;
                if (jj >= v) {
                    chao = true;
                    break;
                }
                for (int k = 1; k <= v && chao == false; k++) {
                    int kk = k * k * k * k;
                    if (jj + kk >= v) {
                        chao = true;
                        break;
                    }

                    for (int l = 1; l <= v; l++) {
                        int ll = l * l * l * l * l;
                        if (jj + kk + ll == v) {
                            System.out.println("YES");
                            yes = true;
                            break;
                        } else if (jj + kk + ll > v) {
                            chao = true;
                            break;
                        }
                    }
                }

            }
            if (chao == true && yes == false) {
                System.out.println("NO");
            }
        }
    }


}
