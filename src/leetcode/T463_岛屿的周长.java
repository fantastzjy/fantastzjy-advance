package leetcode;

public class T463_岛屿的周长 {
    //还有更好解法 迭代处理

    //深度优先搜索
    public int islandPerimeter(int[][] grid) {

        int cir = 0;
        boolean fin = false;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    cir = dfs(grid, i, j);
                    fin = true;
                    break;
                }
                if (fin) {
                    break;
                }
            }
        }

        return cir;
    }

    private int dfs(int[][] grid, int i, int j) {

        //注意这里 数组越界
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return 1;
        }
        if (grid[i][j]==0) {
            return 1;
        }
        if (grid[i][j]==2) {
            return 0;
        }
        grid[i][j] = 2;

        return    dfs(grid, i - 1, j)
                + dfs(grid, i + 1, j)
                + dfs(grid, i, j - 1)
                + dfs(grid, i, j + 1);
    }

    //时间复杂度：O(nm)O(nm)，其中 nn 为网格的高度，mm 为网格的宽度。每个格子至多会被遍历一次，因此总时间复杂度为 O(nm)O(nm)。
    //
    //空间复杂度：O(nm)O(nm)。深度优先搜索复杂度取决于递归的栈空间，而栈空间最坏情况下会达到 O(nm)O(nm)。
    //
    //作者：LeetCode-Solution
    //链接：https://leetcode-cn.com/problems/island-perimeter/solution/dao-yu-de-zhou-chang-by-leetcode-solution/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
