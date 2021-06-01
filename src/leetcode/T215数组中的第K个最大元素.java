package leetcode;

import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * 我的解法 优先队列
 *
 *参考题解  https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/partitionfen-er-zhi-zhi-you-xian-dui-lie-java-dai-/
 */
public class T215数组中的第K个最大元素 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> que = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            que.offer(nums[i]);
            if (que.size() > k) {
                que.poll();
            }
        }

        return que.peek();
    }
}
