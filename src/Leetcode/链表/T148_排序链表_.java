package Leetcode.链表;

import Leetcode.ListNode;

public class T148_排序链表_ {

    public static void main(String[] args) {
        ListNode head1 = new ListNode(4);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(1);
        ListNode head4 = new ListNode(3);
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;


        sortList(head1);
        System.out.println();

     }


    //思路   链表版本的归并排序

    public static ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public static ListNode sortList(ListNode head, ListNode tail) {
        //tail为null则下面咩有必要再去排序
        //有0或1个元素
        if (head == null  || head == tail) {
            return head;
        }

        //只有两个元素
        if (head.next == tail) {
            ListNode sorted = merge(head, tail);
            return sorted;
        }

        //至少三个元素
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }


        ListNode list1 = sortList(head, slow);
        ListNode list2 = sortList(slow.next, tail);
        ListNode sorted = merge(list1, list2);
        return sorted;
    }

    public static ListNode merge(ListNode head1, ListNode head2) {
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