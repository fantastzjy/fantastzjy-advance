package leetcode.岛屿问题;

import java.util.LinkedList;
import java.util.Queue;

public class T200_岛屿数量_bfs {


    class Solution {
        // Leetcode 200. Number of Islands
        // @爱学习的饲养员
        // BFS
        //https://www.bilibili.com/video/BV1Tr4y1K7bA?spm_id_from=333.999.0.0
        // R is the row of grid
        // C is the column of grid
        // Time Complexity: O(RC)
        // Space Complexity: O(RC)
        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }
            int result = 0;
            int row = grid.length;
            int col = grid[0].length;
            Queue<int[]> queue = new LinkedList<>();

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == '1') {
                        result++;

                        queue.add(new int[]{i, j});
                        grid[i][j] = '0';
                        while (queue.size() > 0) {

                            int[] cur = queue.poll();
                            int x = cur[0];
                            int y = cur[1];

                            if (x - 1 >= 0 && grid[x - 1][y] == '1') {
                                queue.add(new int[]{x - 1, y});
                                grid[x - 1][y] = '0';
                            }
                            if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                                queue.add(new int[]{x, y - 1});
                                grid[x][y - 1] = '0';
                            }
                            if (x + 1 < row && grid[x + 1][y] == '1') {
                                queue.add(new int[]{x + 1, y});
                                grid[x + 1][y] = '0';
                            }
                            if (y + 1 < col && grid[x][y + 1] == '1') {
                                queue.add(new int[]{x, y + 1});
                                grid[x][y + 1] = '0';
                            }
                        }
                    }
                }
            }
            return result;
        }
    }
}