package leetcode.岛屿问题;

public class T200_岛屿数量 {

    //方法一：深度优先搜索   沉没法
    //注意传入的是字符数组 要加单引号
    public int numIslands(char[][] grid) {
        int island = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    island++;
                    dfs(grid, i, j);
                }
            }
        }


        return island;
    }

    private void dfs(char[][] grid, int col, int row) {
        if (col < 0 || col >= grid.length || row < 0 || row >= grid[0].length || grid[col][row] == '0') {
            return;
        }
        //别忘了要把当前这个坐标沉没
        grid[col][row] = '0';
        dfs(grid,col+1,row);
        dfs(grid,col-1,row);
        dfs(grid,col,row+1);
        dfs(grid,col,row-1);

    }

    //时间复杂度：O(MN)O(MN)，其中 MM 和 NN 分别为行数和列数。
    //
    //空间复杂度：O(MN)O(MN)，在最坏情况下，整个网格均为陆地，深度优先搜索的深度达到 M NMN。

}
