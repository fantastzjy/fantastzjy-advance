package leetcode.队列_栈_优先队列;

import java.util.LinkedList;
import java.util.Queue;

public class offer225用队列实现栈 {

    class MyStack {
        Queue<Integer> queue;
        private int queue_top;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            queue = new LinkedList<Integer>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            queue.offer(x);
            queue_top = x;  //插入之后栈顶元素就是该元素
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            int size = queue.size();
            //这里大于2是为了提前记录top结果，方便top操作
            while (size > 2) {
                queue.offer(queue.poll());
                size--;
            }
            queue_top = queue.peek();
            queue.offer(queue.poll());
            return queue.poll();
        }

        /**
         * Get the top element.
         */
        public int top() {
            return this.queue_top;
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return queue.isEmpty();
        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

}
