package leetcode.链表;


public class T92_3 {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode pre = null;
        ListNode curr = head;
        ListNode pre2 = null;
        ListNode curr2 = null;
        ListNode next = null;


        for (int i = 1; i <left ; i++) {
            pre = curr;
            curr = curr.next;
        }

        pre2 = pre;
        curr2 = curr;

        for (int i = left; i < right; i++) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = curr.next;
        }

        next = pre.next;
        pre2.next = pre;
        curr2.next = next;

        if (left == 1) {
            head = pre;
        }

        return head;
    }
}