package z7z8.datasource_my.ti;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Dijkstra {
    static int n;
    static int m;
    static int s;
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        s = Integer.parseInt(input[2]);
        int[] dp = new int[n + 1];//记录最小最小路径
        boolean[] isCome = new boolean[n + 1];
        int[][] group = new int[n + 1][n + 1];
        for(int i = 0;i < m;i ++){
            input = bf.readLine().split(" ");
            group[Integer.parseInt(input[0])][Integer.parseInt(input[1])] = Integer.parseInt(input[2]);
        }
        //Dijkstra
        Arrays.fill(dp,INF);
        dp[s] = 0;
        while(true){
            int index = -1;
            for(int i = 1 ; i <= n;i ++){
                if(!isCome[i] &&(index == -1 || dp[i] < dp[index])){
                    index = i;
                }
            }
            if(index == -1) break;
            isCome[index] = true;
            for(int i = 1; i <= n;i ++){
                if(group[index][i] != 0) dp[i] = Math.min(dp[i] , dp[index] + group[index][i]);
            }
        }
        for(int i = 1;i <= n;i ++){
            System.out.print(dp[i] + " ");
        }
    }
}
