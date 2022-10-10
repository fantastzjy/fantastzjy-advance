package fantastzjy.leetcode.链表;


import fantastzjy.leetcode.ListNode;

public class T24_两两交换链表中的节点_ {


    public ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;

        while (pre.next != null && pre.next.next != null) {

            ListNode l1 = pre.next;
            ListNode l2 = pre.next.next;

            l1.next = l2.next;
            l2.next = l1;
            pre.next = l2;
            pre = l1;

        }

        return dummy.next;
    }
}
