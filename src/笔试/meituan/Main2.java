package 笔试.meituan;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main2 {
    static int n;
    static int m;
    static int[][] grap;
    static int[][] ans;
    static boolean[][] isFind;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grap = new int[n + 1][n + 1]; //创建图
        ans = new int[n + 1][n + 1];
        List<Integer>[] la = new List[m + 1];
        for (int i = 0; i < m + 1; i++) {
            la[i] = new LinkedList<>();
        }

        for (int i = 1; i <= n; i++) {
            int k = sc.nextInt();
            //for (int j = 1; i <= k;i++) {//!!!!!!
            for (int j = 1; j <= k; j++) {//!!!!!!
                int num = sc.nextInt();
                for (int e = 0; e < la[num].size(); e++) {
                    int lt = la[num].get(e);
                    grap[i][lt] = 1;
                    grap[lt][i] = 1;
                }
                la[num].add(i);
            }
        }
        isFind = new boolean[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    continue;
                }
                if (isFind[i][j]) {
                    continue;
                }
                isFind[i][j] = true;
                ans[i][j] = bfs(i, j);
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j != n) {
                    System.out.print(ans[i][j] + " ");
                } else {
                    System.out.println(ans[i][j]);
                }
            }
        }

    }

    private static int bfs(int n1, int n2) {
        boolean[] isCome = new boolean[n + 1];   //来过
        Queue<Integer> q = new LinkedList<>();
        isCome[n1] = true;
        q.add(n1);
        int size = 1;
        int ans = 1;
        while (!q.isEmpty()) {
            size = q.size();

            for (int i = 0; i < size; i++) {
                int t = q.poll();
                for (int j = 1; j <= n; j++) {
                    if (grap[t][j] == 1 && !isCome[j]) {
                        if (n2 == j) {
                            return ans;
                        }
                        q.add(j);
                        isCome[j] = true;
                    }
                }
            }

            ans++;
        }
        return 0;

    }
}
