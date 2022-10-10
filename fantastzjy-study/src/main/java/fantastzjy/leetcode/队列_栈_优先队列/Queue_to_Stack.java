package fantastzjy.leetcode.队列_栈_优先队列;

import java.util.LinkedList;
import java.util.Queue;

public class Queue_to_Stack {
    Queue<Integer> queue;

    public Queue_to_Stack() {
        queue = new LinkedList();
    }

    public void add(int n) {
        queue.add(n);
    }

    public int pop() {
        int size = queue.size();
        //这里大于2是为了提前记录top结果，方便top操作
        while (size > 1) {
            queue.offer(queue.poll());
            size--;
        }

        return queue.poll();
    }

}
