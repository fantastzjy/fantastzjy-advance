package Leetcode.岛屿问题;

public class T200_岛屿数量_并查集 {
    class Solution {
        // Leetcode 200. Number of Islands
        // @爱学习的饲养员
        // Union Find
        //https://www.bilibili.com/video/BV1Tr4y1K7bA?spm_id_from=333.999.0.0
        // R is the row of grid
        // C is the column of grid
        // Time Complexity: O(RC)
        // Space Complexity: O(RC)
        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }
            int row = grid.length;
            int col = grid[0].length;
            int waters = 0;
            UnionFind uf = new UnionFind(grid);

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == '0') {
                        waters++;
                    } else {
                        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
                        for (int[] dir : directions) {
                            int x = i + dir[0];
                            int y = j + dir[1];
                            if (x >= 0 && y >= 0 && x < row && y < col && grid[x][y] == '1') {
                                //col 是指数组一共有多少列 不是在第几列
                                uf.union(x * col + y, i * col + j);
                            }
                        }
                    }
                }
            }
            //合并后剩下的格子减去水域的格子
            return uf.getCount() - waters;
        }
    }

    class UnionFind {
        private int[] root = null;
        private int count = 0;

        //初始化
        public UnionFind(char[][] grid) {
            int row = grid.length;
            int col = grid[0].length;
            count = row * col; //统计多少个格子
            root = new int[row * col];  //记录转化为一维数组的祖先关系
            for (int i = 0; i < row * col; i++) {
                root[i] = i;
            }
        }

        // Find the root of X
        //如果相等就是祖先
        //若不相等 继续递归查找 并将返回值设置为当前祖先  直接标记为祖先  下次不用递归查找
        public int find(int x) {
            if (x == root[x]) {
                return x;
            }
            return root[x] = find(root[x]);
        }

        // Union two element into one root
        //如果两个元素的祖先不相等 直接让x的祖先的祖先为y
        // 这里的find方法  会把一路上路过的元素的祖先都直接改为rootX
        //然后 又把祖先rootX的祖先改为rootY！！！！！！
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                root[rootX] = rootY;
                count--;
            }
        }

        public int getCount() {
            return count;
        }
    }
}
