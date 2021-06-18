package leetcode.链表;

//分治算法   类似归并排序
public class T23_合并K个升序链表 {

    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        //basecase
        if (len == 0) {
            return null;
        }

        ListNode list = merge(lists, 0, len - 1);
        return list;
    }

    private ListNode merge(ListNode[] lists, int beg, int end) {
        // basecase   如果beg end相等就是一个不用再分治
        if (beg == end) {
            return lists[beg];
        }

        int mid = (beg + end) / 2;
        ListNode lists1 = merge(lists, beg, mid);
        ListNode lists2 = merge(lists, mid + 1, end);

        return mergeTwo(lists1, lists2);
    }

    private ListNode mergeTwo(ListNode lists1, ListNode lists2) {
        //basecase
        if (lists1 == null) {
            return lists2;
        } else if (lists2 == null) {
            return lists1;
        }
        ListNode pre = new ListNode();
        ListNode tail = pre;

        while (lists1 != null && lists2 != null) {
            if (lists1.val < lists2.val) {
                tail.next = lists1;
                lists1 = lists1.next;
            } else {
                tail.next = lists2;
                lists2 = lists2.next;
            }
            tail = tail.next;
        }

        if (lists1 == null) {
            tail.next = lists2;
        } else {
            tail.next = lists1;
        }
        return pre.next;
    }
    //https://leetcode-cn.com/problems/merge-k-sorted-lists/solution/he-bing-kge-pai-xu-lian-biao-by-leetcode-solutio-2/
    //时间复杂度分析
}
