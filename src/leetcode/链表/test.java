package leetcode.链表;

import leetcode.ListNode;

public class test {
    public static void main(String[] args) {
        ListNode q = new ListNode(1);
        ListNode w = q = q.next;
        //q=q.next.next;
        //ListNode w = q.next;
        if (w == q) {
            System.out.println("true");
        }
    }



}
