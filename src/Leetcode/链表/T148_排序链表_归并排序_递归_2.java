package Leetcode.链表;

import Leetcode.ListNode;

public class T148_排序链表_归并排序_递归_2 {
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = slow.next;
        slow.next = null;

        ListNode listNode1 = sortList(head);
        ListNode listNode2 = sortList(fast);

        ListNode tem = new ListNode();
        ListNode res = tem;
        while (listNode1 != null && listNode2  != null) {
            if (listNode1.val > listNode2.val) {
                tem.next = listNode2;
                listNode2 = listNode2.next;
            } else {
                tem.next = listNode1;
                listNode1 = listNode1.next;
            }
            tem = tem.next;
        }

        tem.next = listNode1 == null ? listNode2 : listNode1;

        return res.next;
    }
}

//  https://leetcode-cn.com/problems/sort-list/solution/sort-list-gui-bing-pai-xu-lian-biao-by-jyd/

