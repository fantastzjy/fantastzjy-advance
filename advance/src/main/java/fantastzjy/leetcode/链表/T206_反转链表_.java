package fantastzjy.leetcode.链表;

import fantastzjy.leetcode.ListNode;

public class T206_反转链表_ {

    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        // pre=null,curr=head,方便反转后的链表尾节点指向null
        ListNode pre = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        return curr;
    }
}



