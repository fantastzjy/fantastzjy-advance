package 笔试.meituan;

import java.util.Scanner;

public class Main32 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int index = num;
        int ans = 0;


        String s = in.next();
        for (int i = num - 1; i >= 0; i--) {
            if (s.charAt(i) == 'a') {
                ans += index - 1 - i;
                index--;
            }
        }

        System.out.println(ans);
    }
}
