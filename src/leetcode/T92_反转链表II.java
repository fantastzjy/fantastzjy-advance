package leetcode;

public class T92_反转链表II {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        //ListNode pre = head;
        ListNode pre = null;
        ListNode curr = head;
        ListNode next = head;
        ListNode pre2 = null;
        ListNode curr2 = null;

        for (int i = 1; i < left; i++) {
            pre = curr;
            curr = curr.next;
        }

        pre2 = pre;
        curr2 = curr;

        //才开始写下面的是想到  如果prev指向要交换的 前面一个的话会导致ledt节点的next指向pre
        //但是不用管这个  因为指向了又如何？ 没关系
        //pre = curr;
        //curr = curr.next;
        //next = curr;

        //遍历一遍 pre前进一步   到最后如果是等于子链表长度的话正好走到 子链表的最后一个 curr和next指向翻转链表后面范围之外的链表
        //for (int i = left; i < right; i++) {
        for (int i = left; i <= right; i++) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        //pre2.next = pre;
        //if (curr != null) {
        //    curr2.next = curr;
        //}

        //if (left==1) {
        //    return pre;
        //}

        //如果pre2 不是null 就正常连接   如果是null  head节点自然就是 pre
        if (pre2 != null) {
            pre2.next = pre;
        } else {
            head = pre;
        }
        curr2.next = curr;

        return head;
    }

    //思考
    //是我考虑多了


}
