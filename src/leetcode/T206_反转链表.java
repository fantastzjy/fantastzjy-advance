package leetcode;

public class T206_反转链表 {

    public ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode curr = head;
        ListNode next = head;

        //1先用next占着 防止找不到
        //2将当前节点直向前一个
        //3将pre先知先curr 因为上一步导致curr的next指向pre 是单向的
        // 先以动curr会导致pre不能移动到正确位置
        //4将curr移到next

        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        return pre;
    }


}
