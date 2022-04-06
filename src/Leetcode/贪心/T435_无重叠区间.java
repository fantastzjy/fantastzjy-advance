package Leetcode.贪心;

import java.util.Arrays;
import java.util.Comparator;

public class T435_无重叠区间 {

    public int eraseOverlapIntervals(int[][] intervals) {

        //将数组结尾按照升序排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int len = intervals.length;

        int count = 1;
        int end = intervals[0][1];
        for (int i = 1; i < len; i++) {
            int start = intervals[i][0];
            if (start >= end) {
                count++;
                end = intervals[i][1];
            }
        }

        return len - count;
    }
}