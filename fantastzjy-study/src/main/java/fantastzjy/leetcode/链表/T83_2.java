package fantastzjy.leetcode.链表;


import fantastzjy.leetcode.ListNode;

public class T83_2 {


    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = new ListNode(1);

        //所有的关于链表的操作都要先考虑传进来的是否为空

        if (head != null) {
            curr = head;
        }

        while (curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {

                curr = curr.next;
            }
        }

        return head;
    }

}
