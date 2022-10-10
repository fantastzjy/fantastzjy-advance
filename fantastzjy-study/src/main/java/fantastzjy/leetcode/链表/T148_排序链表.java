package fantastzjy.leetcode.链表;


import fantastzjy.leetcode.ListNode;

public class T148_排序链表 {

    //思路   链表版本的归并排序
    // 既然是归并排序  就要分段  由于是链表  所以需要找每一个段的头尾节点代替坐标
    //但是没有包含头尾的方法，所以写一个方法包含头尾

    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {

        //basecase

        if (head == null) {
            return head;
        }

        //若相等则说明相邻，让tail算到下一段中当做头
        //这样即使两个是相邻的，这个词返回一个，另一个在另一个递归中返回
        if (head.next == tail) {
            head.next = null;
            return head;
        }

        //找中间值，
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }

        //如果只有一个节点  list1 与 list2 会相同
        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        ListNode sorted = merge(list1, list2);
        return sorted;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }
}


//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/sort-list/solution/pai-xu-lian-biao-by-leetcode-solution/