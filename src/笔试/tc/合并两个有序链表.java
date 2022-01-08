package 笔试.tc;

/**
 * @Package: 笔试.tc
 * @ClassName: 合并两个有序链表
 * @Author: jiaying2.zhang
 * @CreateTime: 2022-1-7 16:18
 * @Description:
 */
public class 合并两个有序链表 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        ListNode pre = new ListNode();
        ListNode res = pre;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                res.next = list1;
                res = res.next;
                list1 = list1.next;
            } else {
                res.next = list2;
                res = res.next;
                list2 = list2.next;
            }

        }

        while (list1 != null) {
            res.next = list1;
            res = res.next;
            list1 = list1.next;
        }
        while (list2 != null) {
            res.next = list2;
            res = res.next;
            list2 = list2.next;
        }

        return pre.next;
    }

}