package leetcode.岛屿问题;

public class T463_岛屿的周长_重点记忆 {
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
            }

            if (fin) {
                break;
            }
        }

        return cir;
    }

    //如果走过的不标记为2 而是直接标记为0 那就乱套了    因为标记边界是两个条件  达到grid的边界、遇到0
    private int dfs(int[][] grid, int i, int j) {
        //basecase

        //1、超过数组界 边界加1
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return 1;
        }
        // 2、超过岛屿边界 边界加1
        if (grid[i][j] == 0) {
            return 1;
        }
        // 3、已经走过 不加
        if (grid[i][j] == 2) {
            return 0;
        }

        //处理
        //4、没走过

        //标记为走过了
        grid[i][j] = 2;

        return dfs(grid, i - 1, j)
                + dfs(grid, i + 1, j)
                + dfs(grid, i, j - 1)
                + dfs(grid, i, j + 1);
    }

    //时间复杂度：O(nm)，其中 n 为网格的高度，m为网格的宽度。每个格子至多会被遍历一次，因此总时间复杂度为 O(nm)。
    //空间复杂度：O(nm)。深度优先搜索复杂度取决于递归的栈空间，而栈空间最坏情况下会达到 O(nm)
    //链接：https://leetcode-cn.com/problems/island-perimeter/solution/dao-yu-de-zhou-chang-by-leetcode-solution/
}
