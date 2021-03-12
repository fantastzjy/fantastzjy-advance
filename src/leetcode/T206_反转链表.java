package leetcode;

public class T206_反转链表 {

    public ListNode reverseList(ListNode head) {

        ListNode curr;
        ListNode pre;
        ListNode temp;
        while (head.next != null) {
            curr = head;
            head = head.next;
            temp = head.next.next;
            head.next.next = curr;
        }

        return null;
    }


}
