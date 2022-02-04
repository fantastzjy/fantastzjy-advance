package leetcode.链表;

import leetcode.ListNode;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 */
public class T25_K个一组翻转链表_多练 {

    public ListNode reverseKGroup(ListNode head, int k) {

        //basecase
        if (head == null || head.next == null || k <= 1) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;

        while (pre != null) {
            //组内的开始节点和结束节点
            //ListNode start = pre;   如果这样导致dummy每次都指向每组的头结点
            //start是实打实的头结点 不是pre了
            ListNode start = pre.next;
            ListNode end = pre.next;

            //定位本组结束的节点    要加上条件end != null
            for (int i = 1; i < k && end != null; i++) {
                end = end.next;
            }

            //不足一组结束反转的循环
            if (end == null) {
                break;
            }
            //暂存后继节点
            ListNode next = end.next;

            //断开后面
            end.next = null;

            //和前面节点连接   第一组反转时 等价于代替dummy.next 完头节点的确定
            //头连接
            pre.next = reverse(start);
            //尾连接
            start.next = next;
            //保证下一轮循环
            pre = start;

        }

        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        //ListNode dummy = new ListNode();
        //dummy.next = head;
        ListNode pre = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        return pre;
    }

}