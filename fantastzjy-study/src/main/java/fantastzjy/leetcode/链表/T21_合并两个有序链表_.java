package fantastzjy.leetcode.链表;


import fantastzjy.leetcode.ListNode;

public class T21_合并两个有序链表_ {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode dummying = new ListNode(-1);
        ListNode curr = dummying;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;

        }

        if (l1 == null) {
            curr.next = l2;
        } else if (l2 == null) {
            curr.next = l1;
        }

        return dummying.next;


    }


    //方法2 递归解法
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        //思考：谁小返回谁   只管当前就好了 next 交给递归就好了

        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {

            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }


    }

}
