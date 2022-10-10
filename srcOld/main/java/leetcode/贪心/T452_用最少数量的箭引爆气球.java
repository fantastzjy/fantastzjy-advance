package leetcode.贪心;

import java.util.Arrays;
import java.util.Comparator;

public class T452_用最少数量的箭引爆气球 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //return o1[1] - o2[1];   //这个和下面的区别在哪？？？   还是老老实实写多的吧
                if (o1[1] > o2[1]) {
                    return 1;
                } else if (o1[1] < o2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        int len = points.length;

        int count = 1;
        int end = points[0][1];
        for (int i = 1; i < len; i++) {
            int start = points[i][0];
            //如果是挨住的话  也会爆炸 就不用再浪费一只弓箭了 所以这个气球的区间可以直接跳过
            // 题目的理解其实是  应该是 只要是能够重叠的区间  一支箭就可以全消灭
            if (start > end) {
                count++;
                end = points[i][1];
            }
        }
        return count;
    }
}