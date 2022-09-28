package z_examination.meituan;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String str = in.next();
        int count = 0;
        char[] chars = str.toCharArray();
        char temp;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (chars[i] < chars[j]) {
                    temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                    count++;
                }
            }
        }
        System.out.println(count);

    }
}
