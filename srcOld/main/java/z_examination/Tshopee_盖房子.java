package z_examination;

public class Tshopee_盖房子 {
    int N = 0;
    boolean[] isComeCol;
    boolean[] isComeX1;
    boolean[] isComeX2;
    int count = 0;

    public int buildHouses(int n) {
        N = n;
        isComeCol = new boolean[N + 1];
        isComeX1 = new boolean[2 * N + 1];
        isComeX2 = new boolean[2 * N + 1];
        dfs(0);
        return count;
    }

    public void dfs(int row) {
        if (row == N) {
            count++;
            return;
        }
        for (int i = 0; i < N; i++) {
            //三个判断条件
            if (!isComeCol[i] && !isComeX1[N + row - i] && !isComeX2[row + i]) {
                isComeCol[i] = true;
                isComeX1[N + row - i] = true;
                isComeX2[row + i] = true;
                dfs(row + 1);
                isComeCol[i] = false;
                isComeX1[N + row - i] = false;
                isComeX2[row + i] = false;
            }
        }
    }
}
