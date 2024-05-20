package fantastzjy.leetcode.链表;

import fantastzjy.leetcode.ListNode;

public class T206_反转链表 {

    //一句话：标记下一个，指向前一个，再丢掉前一个
    public ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode curr = head;
        ListNode next = head;

        //1先用next占着 防止找不到
        //2将当前节点直向前一个
        //3将pre先知先curr 因为上一步导致curr的next指向pre 是单向的
        // 先以动curr会导致pre不能移动到正确位置
        //4将curr移到next

        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        return pre;
    }

    //反例
    //只会返回最后末尾的数  因为curr的指针没有指向前面  且会造成死循环 最后的头结点与第二个节点循环
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;

        }
        ListNode pre = head;
        ListNode curr = head.next;
        ListNode next = null;
        while (curr.next != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        return curr;
    }

    // 错2  pre初始指向head,导致head.next指向第二个节点,造成循环
    // pre=null,curr=head,方便反转后的链表尾节点指向null
    // 后面遇到链表的,pre=null,curr=head开始尝试
    public ListNode reverseList2(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = head;
        ListNode curr = head.next;
        ListNode next = null;

        while (curr != null) {
            // 标记下一个
            next = curr.next;
            // 指向上一个
            curr.next = pre;
            // 向前进一步
            pre = curr;
            // 向前进一步
            curr = next;
        }

        return pre;
    }
}



