package leetcode;

import java.util.PriorityQueue;

public class T703_数据流中的第K大元素 {
    class KthLargest {
        PriorityQueue<Integer> pq;
        int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            pq = new PriorityQueue<>();
            for (int num : nums) {
                add(num);
            }
        }

        //要先添加进去，如果size大于k再拿出来  里面就顺带比较了大小了
        public int add(int val) {
            pq.offer(val);
            if (pq.size() > k) {
                pq.poll();
            }
            return pq.peek();

        }
    }

}


