package leetcode.链表;

public class T24_3 {

    public ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode curr = dummy;

        while (curr.next != null) {
            ListNode n1 = curr.next;
            ListNode n2 = curr.next.next;

            //按照从前往后的顺序比较快  尽量按顺序
            curr.next = n2;
            n1.next = n2.next;
            n2.next = n1;

            curr = n1;
            //在刚进循环的时候定义
            //n1 = n1.next;
            //n2 = n1.next;

        }


        return dummy.next;
    }


}
