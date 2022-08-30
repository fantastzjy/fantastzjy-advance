package leetcode.链表;

import leetcode.ListNode;

public class T61_旋转链表 {

    //官方解法 闭合成环
    public ListNode rotateRight(ListNode head, int k) {
        //basecase
        if (k == 0 || head == null || head.next == null) {
            return head;
        }

        //n初始值为1 在第一个位置上停着 进入一次循环就会行前走一步
        // 走到最后一个节点就正好是长度  停在最后一个节点上
        int n = 1;
        ListNode iterator = head;
        while (iterator.next != null) {
            n++;
            iterator = iterator.next;
        }

        //闭合成环
        iterator.next = head;

        //这个step停留在最后一个节点
        //要移动的步数=n-k%n 因为iterator本来是在链的最后一个节点
        //从后往前看  k % n 也可以想象成旋转的步数   n-k%n 就是指向末尾
        int step = n - k % n;

        //形成环后 指针移动到哪里 哪里就是尾部

        while (step-- > 0) {
            iterator = iterator.next;
        }
        ListNode res = iterator.next;
        iterator.next = null;

        return res;

    }
    //題解來自
    //https://leetcode-cn.com/problems/rotate-list/solution/xuan-zhuan-lian-biao-by-leetcode-solutio-woq1/

}