package 笔试;

import java.util.Scanner;

public class 便利蜂1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String[] split = str.split(",");

        int[] dp = new int[split.length];

        dp[0] = Integer.parseInt(split[0]);
        dp[1] = Math.max(dp[0], Integer.parseInt(split[1]));

        for (int i = 2; i < split.length; i++) {
            dp[i] = Math.max(Integer.parseInt(split[i]) + dp[i - 2], dp[i - 1]);
        }

        System.out.println(dp[split.length - 1]);

    }


}
