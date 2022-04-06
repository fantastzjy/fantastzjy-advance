package Leetcode.岛屿问题;

public class T695_岛屿的最大面积 {

    //方法一：深度优先搜索   沉没法
    //注意传入的是字符数组 要加单引号
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, dfs(grid, i, j));
                }
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int col, int row) {
        if (col < 0 || col >= grid.length || row < 0 || row >= grid[0].length || grid[col][row] == 0) {
            return 0;
        }
        //别忘了要把这个坐标沉没   自身的面积初始为1！！！！
        grid[col][row] = 0;
        int islandAre = 1;
        islandAre += dfs(grid, col + 1, row);
        islandAre += dfs(grid, col - 1, row);
        islandAre += dfs(grid, col, row + 1);
        islandAre += dfs(grid, col, row - 1);

        return islandAre;
    }


    //时间复杂度：O(R \times C)O(R×C)。其中 RR 是给定网格中的行数，C 是列数。我们访问每个网格最多一次。
    //空间复杂度：O(R \times C)O(R×C)，递归的深度最大可能是整个网格的大小，因此最大可能使用 O(R \times C)O(R×C) 的栈空间。
    //
    //链接：https://leetcode-cn.com/problems/max-area-of-island/solution/dao-yu-de-zui-da-mian-ji-by-leetcode-solution/
}
