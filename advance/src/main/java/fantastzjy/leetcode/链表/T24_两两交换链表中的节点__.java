package fantastzjy.leetcode.链表;


import fantastzjy.leetcode.ListNode;

public class T24_两两交换链表中的节点__ {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode curr = head;
        ListNode dummy = new ListNode();
        dummy.next = curr.next;
        ListNode pre = dummy;

        while (curr.next != null && curr.next != null) {
            ListNode l1 = curr;
            ListNode l2 = curr.next;

            curr = curr.next.next;

            pre.next = l2;
            l2.next = l1;
            l1.next = curr;

            pre = l1;
        }

        return dummy.next;
    }
}