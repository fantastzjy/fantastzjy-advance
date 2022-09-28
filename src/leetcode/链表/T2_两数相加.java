package leetcode.链表;


import leetcode.ListNode;

public class T2_两数相加 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int temp = 0;
        int sum = 0;

        //没说两个链表一样长  其中一个为null的时候当做0处理
        //while (l1 != null && l2 != null) {
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;

            sum = n1 + n2 + temp;

            //temp = 0; 不用  下面如果就一位数 除以10 结果就是0
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                //tail代表当前链表的末尾就好了  增加新的数还是要续到tail后面
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            //没说链表一样长
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            temp = sum / 10;
        }
        if (temp > 0) {
            tail.next = new ListNode(temp);
        }
        return head;
    }
}