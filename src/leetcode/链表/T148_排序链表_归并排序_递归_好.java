package leetcode.链表;

import leetcode.ListNode;

public class T148_排序链表_归并排序_递归_好 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        //这里不用纠结到底是不是找出的中间值  找中间值 用于大致的切分就可
        //这样赋值 可以保证快指针正好是慢指针的二倍 但不一定会走到最后
        ListNode fast = head.next, slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode tmp = slow.next;
        //要将前后两部分之间的联系切断
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);

        //merge
        //不将merge方法，省事
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        //直接赋值就行，不用像数组那样再把剩余的便利一遍！！！！
        h.next = left != null ? left : right;
        return res.next;
    }
}

// 本答案 https://leetcode-cn.com/problems/sort-list/solution/sort-list-gui-bing-pai-xu-lian-biao-by-jyd/
//  本题官方答案  https://leetcode-cn.com/problems/sort-list/solution/sort-list-gui-bing-pai-xu-lian-biao-by-jyd/
