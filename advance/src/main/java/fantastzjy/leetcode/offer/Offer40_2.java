package fantastzjy.leetcode.offer;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Offer40_2 {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        if (k == 0) { // 排除 0 的情况
            return res;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < arr.length; i++) {
            if (queue.offer(arr[i])) {
                if (queue.size() > k) {
                    queue.poll();
                }
            }
        }

        //for (int i = 0; i <arr.length ; i++) {
        //    queue.offer(arr[i]);
        //}

        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }
}