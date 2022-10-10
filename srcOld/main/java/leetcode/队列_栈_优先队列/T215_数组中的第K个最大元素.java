package leetcode.队列_栈_优先队列;

import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * 我的解法 优先队列
 *
 *参考题解  https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/partitionfen-er-zhi-zhi-you-xian-dui-lie-java-dai-/
 */
public class T215_数组中的第K个最大元素 {
    public int findKthLargest(int[] nums, int k) {
        //Java中PriorityQueue通过二叉小顶堆实现，可以用一棵完全二叉树表示  堆顶的是最小元素 ！！所以取出来的就是K大元素
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
