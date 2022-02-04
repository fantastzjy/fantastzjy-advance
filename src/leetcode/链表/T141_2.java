package leetcode.链表;


import leetcode.ListNode;

import java.util.HashSet;
import java.util.Set;

public class T141_2 {

    //方法二：快慢指针
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if (head != null) {

            while (fast.next!= null&&fast.next.next!=null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    return true;
                }
            }
        }

        return false;
    }



    //方法一：哈希表

    public boolean hasCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<>();

        while (head != null) {

            //boolean iscontain = set.contains(head);
            //if (iscontain) {
            //    return true;
            //}
            //set.add(head);
            //hashset添加失败本来就会返回false
            if (!set.add(head)) {
                return true;
            }
            //链表要继续往后走别忘了
            head = head.next;
        }
        return false;
    }


}
