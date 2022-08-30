package leetcode.链表;

import leetcode.ListNode;

public class T24_两两交换链表中的节点 {

    //给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
    //你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。


    public ListNode swapPairs(ListNode head) {
        //curr才开始值得是dummy对应的node节点  在第一次循环时   curr.next = n2; 就是让dummy.next指向了第一个节点
        //       而  dummy.next = head;是为了让curr.next 为head 好进行赋值
        ListNode dummy = new ListNode();
        //ListNode dummy2 = new ListNode();
        dummy.next = head;
        //dummy2 = head.next;
        //ListNode curr = head;
        ListNode curr = dummy;

        //如果只有一个节点，就不会进入该循环 直接返回
        //如果最后只有一个节点 也不会进入是按照原样放着 就行
        while (curr.next != null && curr.next.next != null) {
            ListNode n1 = curr.next;
            ListNode n2 = curr.next.next;

            //按照从前往后的顺序比较快  尽量按顺序
            //直接用n1.next存储n2.next  顺便对n1 向后面做一个连接 ！！！！！！
            n1.next = n2.next;
            n2.next = n1;

            curr.next = n2;


            curr = n1;

            //在刚进循环的时候定义
            //n1 = n1.next;
            //n2 = n1.next;
        }

        //第一次循环的时候 curr就是dummy
        return dummy.next;

    }
}
