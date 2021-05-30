package leetcode.链表;


public class T92_2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode pre = null;
        ListNode curr = head;
        ListNode pre2 = null;
        ListNode curr2 = null;
        ListNode next = null;

        //注意这里要从1开始了（题目给出示例）
        //如果没有进入该循环 pre2 也会是null  后面根据pre2是否为null 来确定最终的头结点
        //要让他们都在正确的位置上 curr才开始指向得就是 head 进入一次循环 curr前进一步  假如left=5   就会进入四次循环 1+4=5

        for (int i = 1; i < left; i++) {
            pre = curr;
            curr = curr.next;
        }

        //做暂存
        pre2 = pre;
        curr2 = curr;

        //后面是i <= right 因为要让curr等于区间的下一个
        for (int i = left; i <= right; i++) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        if (pre2 != null) {
            pre2.next = pre;
        } else {
            head = pre;
        }

        curr2.next = curr;

        return head;
    }
}
