package leetcode.链表;

public class T142_3 {

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        boolean iscir = false;

        //前面也是fast   fast跑得快！！！
        //while (slow.next != null && fast.next.next != null) {
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                iscir = true;
                break;
            }
        }
        if (!iscir) {
            return null;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
