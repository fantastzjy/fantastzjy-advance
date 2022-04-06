package Leetcode.链表;

import Leetcode.ListNode;

public class T83_删除排序链表中的重复元素 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = new ListNode(1);

        //所有的关于链表的操作都要先考虑传进来的是否为空

        if (head != null) {
            curr = head;
        }

        //真妙啊 连快慢指针都不用
        while (curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return head;
    }

}
