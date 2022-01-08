package 笔试.tc;

/**
 * @Package: 笔试.tc
 * @ClassName: 反转链表
 * @Author: jiaying2.zhang
 * @CreateTime: 2022-1-7 11:30
 * @Description:
 */
public class 反转链表 {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;

        }
        ListNode pre = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr!= null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;

        }

        return pre;
    }


}
