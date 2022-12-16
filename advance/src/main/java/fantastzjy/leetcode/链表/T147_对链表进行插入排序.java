package fantastzjy.leetcode.链表;

import fantastzjy.leetcode.ListNode;

public class T147_对链表进行插入排序 {
    //总结：能直接交换值，就不要想着交换节点
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(-1, head);
        ListNode curr = head.next;
        while (curr != null) {
            ListNode flag = dummy.next;

            while (flag.next != null) {
                if (curr.val < flag.val) {
                    int t = curr.val;
                    curr.val = flag.val;
                    flag.val = t;
                }
                flag = flag.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
