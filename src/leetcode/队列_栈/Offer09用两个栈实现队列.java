package leetcode.队列_栈;

import java.util.Stack;

public class Offer09用两个栈实现队列 {
}

class CQueue {
    private Stack s1, s2;


    //队列初始化
    public CQueue() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }

    //在队列尾部添加元素
    public void appendTail(int value) {
        s1.push(value);
    }

    //删除队列头的元素并返回
    public int deleteHead() {
        //labuladong算法错误
        // 当 取出元素后没取完 再插入新值后
        // 再取出的话  不能立即就把s1 的值加入到s2 中
        // 不然新加入的会比之前的更早出来  应先判断s2 是否为空 再把s1  元素添加到时s2
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

    //另外 判断由两个栈实现的队列时  要判断两个栈是否都为空才行

}