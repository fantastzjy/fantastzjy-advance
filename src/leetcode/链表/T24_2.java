package leetcode.链表;

public class T24_2 {

    public ListNode swapPairs(ListNode head) {
        //curr才开始值得是dummy对应的node节点  在第一次循环时   curr.next = n2; 就是让dummy.next指向了第一个节点
        //       而  dummy.next = head;是为了让curr.next 为head 好进行赋值
        ListNode dummy = new ListNode();
        dummy.next = head;
        //ListNode curr = head;
        ListNode curr = dummy;

        ListNode n1 = null;
        ListNode n2 = null;

        while (curr.next != null && curr.next.next != null) {
            n1 = curr.next;
            n2 = curr.next.next;

            curr.next = n2;
            n1.next = n2.next;
            n2.next = n1;
            curr = n1;

        }

        return dummy.next;
    }


    //public ListNode swapPairs(ListNode head) {
    //
    //
    //    ListNode pre = head;
    //    ListNode curr = head.next;
    //    ListNode dummy = head.next;
    //    ListNode next = null;
    //
    //    while (curr != null && curr.next != null) {
    //        next = curr.next;
    //        curr.next = pre;
    //        pre.next = next;
    //        pre = next;
    //        curr = pre.next;
    //    }
    //
    //    return dummy;
    //}
}
