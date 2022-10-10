package leetcode.链表;


import leetcode.ListNode;

import java.util.HashSet;
import java.util.Set;

public class T141_环形链表 {

    //方法二：快慢指针
    public boolean hasCycle(ListNode head) {
        //这里要先进行判断 传进来的head是否为null    忘记判断了
        //if (head != null) {   判断的条件判断两个更好 至少三个才能形成环
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        //边界问题如何确定？？看谁走的快 神谁在边上;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            //这里要直接进行节点的比较 不是val值得比较    这里如果   slow == fast   比较的才是 是不是相同节点
            //if (slow.val == fast.val) {
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    //时间复杂度：O(N)O(N)，其中 NN 是链表中的节点数。
    //当链表中不存在环时，快指针将先于慢指针到达链表尾部，链表中每个节点至多被访问两次。
    //当链表中存在环时，每一轮移动后，快慢指针的距离将减小一。而初始距离为环的长度，因此至多移动 NN 轮。
    //空间复杂度：O(1)O(1)。我们只使用了两个指针的额外空间。


    //方法一：哈希表

    public boolean hasCycle2(ListNode head) {
        Set<ListNode> seen = new HashSet<ListNode>();
        while (head != null) {
            if (!seen.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    //时间复杂度：O(N)
    //空间复杂度：O(N)，其中 N 是链表中的节点数
    //作者：LeetCode-Solution
    //链接：https://leetcode-cn.com/problems/linked-list-cycle/solution/huan-xing-lian-biao-by-leetcode-solution/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

}
