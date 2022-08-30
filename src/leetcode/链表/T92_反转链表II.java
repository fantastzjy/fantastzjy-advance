package leetcode.链表;

//两个循环确定要翻转的区间
//额外定义几个指针用作暂存边界位置节点
//前面用pre curr标记 后面用next标记 当区间返转完 pre走到了区间的最后一个节点

import leetcode.ListNode;

/*将一段翻转*/
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
        //pre = curr;T92_反转链表IIT92_反转链表II
        //curr = curr.next;
        //next = curr;

        //for (int i = left; i < right; i++) {
        for (int i = left; i <= right; i++) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }


        //如果pre2 不是null 就正常连接   如果是null  head节点自然就是 pre
        if (pre2 != null) {
            pre2.next = pre;
        } else {
            head = pre;
        }
        curr2.next = curr;
        return head;
    }

}
