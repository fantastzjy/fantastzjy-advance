package leetcode.并查集;


public class UnionFind_二维数组 {
    int[] root;
    int row;
    int col;

    public UnionFind_二维数组(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        root = new int[row * col];
        for (int i = 0; i < row * col; i++) {
            root[i] = i;
        }
    }

    public int find(int x) {
        if (x == root[x]) {
            return x;
        } else {
            return root[x] = find(root[x]);
        }
    }

    public void union(int x, int y) {
        int xx = find(x);
        int yy = find(y);
        if (xx != yy) {
            root[x] = yy;
        }
    }
}