package Leetcode.链表;

import Leetcode.ListNode;

public class T206_反转链表_ {

    public ListNode reverseList(ListNode head) {

        ListNode curr = head;
        ListNode pre = null;
        ListNode next = null;


        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        return pre;

    }

}



