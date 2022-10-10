package fantastzjy.leetcode.链表;


import fantastzjy.leetcode.ListNode;

public class T142_环形链表II {

    public ListNode detectCycle(ListNode head) {

        //不管何时都要进行判断是否为null
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        boolean isCir = false;

        //前面也是fast   fast跑得快！！！
        //while (slow.next != null && fast.next.next != null) {
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                isCir = true;
                break;
            }
        }

        if (!isCir) {
            return null;
        }

        //要把快或者慢指针移到开头
        fast = head;
        //然后一步一步走
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }


}
