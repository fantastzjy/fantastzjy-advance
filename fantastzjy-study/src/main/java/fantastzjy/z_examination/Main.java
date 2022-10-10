package fantastzjy.z_examination;

import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.println(new Main().intlongest(s1, s2));

    }

    public int intlongest(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dpnum = new int[len1][len2];
        for (int i = 0; i < dpnum.length; i++) {
            Arrays.fill(dpnum[i], Integer.MIN_VALUE);
        }
        return dpCount(dpnum, s1, 0, s2, 0);
    }

    public int dpCount(int[][] dpnum, String s1, int i, String s2, int j) {
        if (s1.length() == i || s2.length() == j) {
            return 0;
        }

        if (dpnum[i][j] != Integer.MIN_VALUE) {
            return dpnum[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            dpnum[i][j] = 1 + dpCount(dpnum, s1, i + 1, s2, j + 1);
        } else {
            dpnum[i][j] = Math.max(dpCount(
                            dpnum, s1, i + 1, s2, j)
                    , dpCount(dpnum, s1, i, s2, j + 1));
        }

        return dpnum[i][j];
    }


}
