package z_examination;

import java.util.Scanner;

public class Main2 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[10];
        for (int i = 0; i < 10; i++) {
            nums[i] = sc.nextInt();

        }

        int n1 = 0;
        int n2 = 0;
        int n3 = 0;
        for (int i = 0; i < 10; i++) {
            if (nums[i] == 1) {
                n1++;
            }
            if (nums[i] == 2) {
                n2++;
            }
            if (nums[i] == 3) {
                n3++;
            }
        }
        for (int i = 0; i < 10; i++) {
            if (n1 > 0) {
                System.out.print(1 + " ");
                n1--;
                continue;
            }
            if (n2 > 0) {
                System.out.print(2 + " ");
                n2--;
                continue;
            }
            if (n3 > 0) {
                if (n3 > 1) {
                    System.out.print(3 + " ");
                }
                if (n3 == 1) {
                    System.out.print(3);
                }
                n3--;

            }
        }


    }
}