package fantastzjy.leetcode.链表;

//两个循环确定要翻转的区间
//额外定义几个指针用作暂存边界位置节点
//前面用pre curr标记 后面用next标记 当区间返转完 pre走到了区间的最后一个节点


import fantastzjy.leetcode.ListNode;

public class T92_反转链表II_2_错了未改正 {

    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummy = new ListNode();
        ListNode pre = dummy;
        ListNode curr = head;

        ListNode pre2 = null;
        ListNode curr2 = null;

        pre.next = curr;


        for (int i = 1; i < left && curr.next != null; i++) {
            pre.next = curr;
            curr = curr.next;
        }

        pre2 = pre;
        curr2 = curr;


        for (int i = left; i <= right && curr != null; i++) {
            pre = pre.next;
            curr = curr.next;
        }

        ListNode next = curr;
//       开始翻转
        //切断与后面联系
        pre.next = null;

        ListNode pre3 = null;
        ListNode curr3 = curr2;

        while (curr2 != null) {
            ListNode n = curr2.next;
            curr2.next = pre3;
            pre3 = curr2;
            curr2 = n;
        }

        pre2.next = pre;
        curr3.next = next;


        return dummy.next;
    }


}
