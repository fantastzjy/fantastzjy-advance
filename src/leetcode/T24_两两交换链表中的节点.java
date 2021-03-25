package leetcode;

public class T24_两两交换链表中的节点 {

    //给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
    //你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。


    public ListNode swapPairs(ListNode head) {

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
            //n1n2 此轮循环没有改变 所以顺序不影响
            curr.next = n2;
            n1.next = n2.next;
            n2.next = n1;
            curr = n1;

        }


        //为什么要返回dummy.next呢  因为 dummy.next 指向的已经不是head节点 而是交换之后的 真正的头结点
        // 之前疑惑在返回dummy.next 就是才开始定义的head  错认为是不正确的   但是忽略了 在while循环中已经交换过了
        return dummy.next;
        //return dummy2;
    }
}
