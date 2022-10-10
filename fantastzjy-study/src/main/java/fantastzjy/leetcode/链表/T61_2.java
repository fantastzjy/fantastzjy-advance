package fantastzjy.leetcode.链表;


import fantastzjy.leetcode.ListNode;

public class T61_2 {

    //官方解法 闭合成环
    public ListNode rotateRight(ListNode head, int k) {

        //basecase   注意 不是 k == 1  应该是 k == 0   一步都不走才直接返回
        if (head == null || k == 0 | head.next == null) {
            return head;
        }

        //计算长度
        ListNode iter = head;
        int n = 1;
        //才开始是n=1 能进去说明next不为null 往前走一步
        while (iter.next != null) {
            n++;
            iter = iter.next;
        }

        //闭合成环、
        iter.next = head;

        //k是要走的步数  走完之后 指针位置停在哪里？ 当然是总长度减走的步数 想象环在旋转
        int step = n - k % n;

        while (step-- > 0) {
            iter = iter.next;
        }

        ListNode res = iter.next;
        //断开环
        iter.next = null;

        return res;

    }
    //題解來自
    //https://leetcode-cn.com/problems/rotate-list/solution/xuan-zhuan-lian-biao-by-leetcode-solutio-woq1/

}