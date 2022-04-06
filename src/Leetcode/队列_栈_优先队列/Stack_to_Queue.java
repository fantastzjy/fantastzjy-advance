package Leetcode.队列_栈_优先队列;

import java.util.Stack;

public class Stack_to_Queue {
    Stack s1, s2;

    public Stack_to_Queue() {
        s1 = new Stack();
        s2 = new Stack();
    }

    public void add(int n) {
        s1.add(n);

    }

    public int pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        if (!s2.isEmpty()) {
            return (int) s2.pop();
        }
        return -1;
    }


}
