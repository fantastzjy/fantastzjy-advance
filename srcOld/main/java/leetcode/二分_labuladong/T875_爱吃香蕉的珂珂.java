package leetcode.二分_labuladong;

public class T875_爱吃香蕉的珂珂 {

    int minEatingSpeed(int[] piles, int H) {
        // 套用搜索左侧边界的算法框架
        int left = 1, right = getMax(piles) + 1;
        while (left < right) {
            // 防止溢出

            int mid = left + (right - left) / 2;
            if (canFinish(piles, mid, H)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 时间复杂度 O(N)
    boolean canFinish(int[] piles, int speed, int H) {
        int time = 0;
        for (int n : piles) {
            time += timeOf(n, speed);
        }
        return time <= H;
    }

    int timeOf(int n, int speed) {
        return (n / speed) + ((n % speed > 0) ? 1 : 0);
    }

    int getMax(int[] piles) {
        int max = 0;
        for (int n : piles) {
            max = Math.max(n, max);
        }
        return max;
    }

}
