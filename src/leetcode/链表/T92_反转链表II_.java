package leetcode.链表;

import leetcode.ListNode;

public class T92_反转链表II_ {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        //思路：将两头保存，反转中间

        ListNode pre = null;
        ListNode pre2 = null;
        ListNode curr = head;
        ListNode curr2 = null;


        //找到头

        for (int i = 1; i < left; i++) {
            pre = curr;
            curr = curr.next;
        }

        pre2 = pre;
        curr2 = curr;
        //招到尾  思考 因为反转需要curr越界 才能保证蕲艾面反转完成
        ListNode tail = curr;
        for (int i = left; i <= right; i++) {
            tail = tail.next;
        }


        //反转中间
        pre = null;
        while (curr != tail && curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }


        //处理头尾
        //尾
        if (tail != null) {
            curr2.next = tail;
        }

        if (pre2 != null) {
            pre2.next = pre;
            return head;
        } else {
            return pre;
        }


    }
}
