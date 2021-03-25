package leetcode;

public class T21_合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode prehead = new ListNode(-1);
        ListNode newList = prehead;

        //如果是判断next 是否为null 就会导致当前节点无法进行 比较插入
        //while (l1.next != null && l2.next != null) {
        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                newList.next = l1;
                l1 = l1.next;
                //newList = newList.next;   移到下面
            } else {
                newList.next = l2;
                l2 = l2.next;
                //newList = newList.next;   移到下面
            }

            newList = newList.next;
        }

        if (l1 == null) {
            newList.next = l2;
        }
        //第二个也必须加判断  不然如果是null 就会导致 上面天怒家的l2 为 null
        if (l2 == null) {
            newList.next = l1;
        }


        return prehead.next;
    }

    //时间复杂度：O(n + m)O(n+m)，其中 nn 和 mm 分别为两个链表的长度。
    // 因为每次循环迭代中，l1 和 l2 只有一个元素会被放进合并链表中，
    // 因此 while 循环的次数不会超过两个链表的长度之和。
    // 所有其他操作的时间复杂度都是常数级别的，因此总的时间复杂度为 O(n+m)O(n+m)。
    //
    //空间复杂度：O(1)O(1)。我们只需要常数的空间存放若干变量。
    //
    //作者：LeetCode-Solution
    //链接：https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/he-bing-liang-ge-you-xu-lian-biao-by-leetcode-solu/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。






    //方法2 递归解法
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }

    //递归解法先进行 其中有一个是否为null的判断  然后、、、  不断地调用自身的函数 进行递归


    //作者：LeetCode-Solution
    //链接：https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/he-bing-liang-ge-you-xu-lian-biao-by-leetcode-solu/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
