package leetcode.链表;

//两个循环确定要翻转的区间
//额外定义几个指针用作暂存边界位置节点
//前面用pre curr标记 后面用next标记 当区间返转完 pre走到了区间的最后一个节点

import leetcode.ListNode;

public class T92_4_笔记 {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode pre = null;
        ListNode curr = head;
        ListNode pre2 = null;
        ListNode curr2 = null;
        ListNode next = null;

        //注意这里要从1开始了（题目给出示例）
        //如果没有进入该循环 pre2 也会是null  后面根据pre2是否为null 来确定最终的头结点

        // curr才开始指向得就是 head 进入一次循环 curr前进一步
        //若left=5  就会进入四次循环  1+4=5   循环结束pre会指向区间前一个 curr指向区间第一个 因为初始值 curr = head  i=1
        for (int i = 1; i < left; i++) {
            pre = curr;
            curr = curr.next;
        }

        //做暂存
        pre2 = pre;
        curr2 = curr;

        //才开始curr指向第一个 每一次循环curr指向前面的pre  要想区间全部反转 就要走区间长度的步数
        // 假如区间长度=5 就要交换5次才可 “所以后面就要等于right”  每次循环中交换完毕后curr才会指向下一个
        //  最后pre等于区间最后一个  curr指向区间外第一个 但是还没有交换  至此区间内的全部交换完
        for (int i = left; i <= right; i++) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = curr.next;
        }

        //设置头结点
        // 看前面第一个循环是否进入  如果pre2 不是null 就正常连接   如果是null  head节点自然就是 pre
        if (pre2 != null) {
            pre2.next = pre;
        } else {
            head = pre;
        }

        //设置尾结点
        curr2.next = curr;

        return head;
    }
}