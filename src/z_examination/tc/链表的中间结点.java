package z_examination.tc;

/**
 * @Package: 笔试.tc
 * @ClassName: 链表的中间结点
 * @Author: jiaying2.zhang
 * @CreateTime: 2022-1-7 11:40
 * @Description:
 */
public class 链表的中间结点 {

    public ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}