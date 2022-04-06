package Leetcode.链表;

import Leetcode.ListNode;

public class T82_2 {
    //官网方法一：一次遍历

    //自己的方法效率低
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode fast = head.next;
        ListNode slow = dummy;
        boolean is = false;

        while (fast != null) {
            while (fast != null && slow.next.val == fast.val) {
                fast = fast.next;
                is = true;
            }
            if (is) {
                slow.next = fast;
                is = false;
            } else {
                slow = slow.next;
            }
            if (fast == null) {
                break;
            }
            fast = fast.next;

        }

        return dummy.next;
    }
}
