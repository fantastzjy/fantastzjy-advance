package leetcode.offer;

public class Offer22_链表中倒数第k个节点 {

    //思想 用快慢指针 当快指针走到第n个节点时 慢指针开始走 这样快慢指针相隔n个节点
    //当快指针走到末尾时 慢指针就是倒数第n

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head==null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k&&fast.next!=null; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow.next;
    }
}
