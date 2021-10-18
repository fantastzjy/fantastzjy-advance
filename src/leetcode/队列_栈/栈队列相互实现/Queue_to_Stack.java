package leetcode.队列_栈.栈队列相互实现;

import java.util.LinkedList;
import java.util.Queue;

public class Queue_to_Stack {
    Queue q1;

    public Queue_to_Stack() {
        q1 = new LinkedList();
    }

    public void add(int n) {
        q1.add(n);
    }

    public int pop() {
        int n = q1.size();
        if (n > 0) {
            for (int i = 0; i < n - 2; i++) {
                q1.add(q1.poll());
            }
        }
        return -1;
    }


}
