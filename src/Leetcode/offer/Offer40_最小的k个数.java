package Leetcode.offer;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Offer40_最小的k个数 {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] vec = new int[k];
        if (k == 0) { // 排除 0 的情况
            return vec;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {

            @Override
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;  //!!!!!!!!!!
            }
        });

        for (int i = 0; i < k; ++i) {
            queue.offer(arr[i]);
        }

        for (int i = k; i < arr.length; ++i) {
            if (queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; ++i) {
            vec[i] = queue.poll();
        }
        return vec;
    }
}