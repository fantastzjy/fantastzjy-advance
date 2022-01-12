package 比赛;

public class t2 {

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
        while (listNode1 != null && listNode2 != null) {
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

