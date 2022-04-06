package Leetcode.链表;

import Leetcode.ListNode;

public class T328_奇偶链表 {
    public ListNode oddEvenList(ListNode head) {

        if (head == null) {
            return head;
        }

        ListNode ji = head;
        ListNode ou = head.next;
        ListNode ouhead = head.next;

        //奇数的next为ou 奇数的nextnext为ou.next   可防止越界
        //当最后一个是奇数的时候
        // ：倒数第二个是偶数位 此时他的next指向的是奇数的下一位 为null 判断ou==null结束循环
        //当最后一位是偶数的时候
        // ：倒数第一位的偶数位此时他的next仍然是null    判断ou.next==null结束循环

        //是while循环不是if！！！
        // 循环条件是根据  ou.next = ou.next.next;    偶数总是在最前面
        while (ou != null && ou.next != null) {
            ji.next = ji.next.next;
            ji = ji.next;
            ou.next = ou.next.next;
            ou = ou.next;
        }
        ji.next = ouhead;

        return head;
    }
}
