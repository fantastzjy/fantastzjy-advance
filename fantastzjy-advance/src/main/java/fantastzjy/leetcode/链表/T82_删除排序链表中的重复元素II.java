package fantastzjy.leetcode.链表;


import fantastzjy.leetcode.ListNode;

public class T82_删除排序链表中的重复元素II {
    //官网方法一：一次遍历

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                //用x标记  只要相等就全删了  顺便直接把第一个节点也删除了
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    //如果相等 就等于下一个   当下一个进不来该循环 cur就正好是不相等的那一个
                    //当相等时 curr的next一直在被替代
                    //当不相等后 curr也正好变成了 不相等的那个 跳出本while 重复的也被删完了
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }

            //如果相等 会停留在相等的最后一个 如果不相等 会停留在当前 然后 cur = cur.next;
            //直接将下一个赋值给当前就是往前走  如果将下下个赋值给当前就是删除中间的那个
        }
        return dummy.next;
    }


    //作者：LeetCode-Solution
    //链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/solution/shan-chu-pai-xu-lian-biao-zhong-de-zhong-oayn/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


    //我的方法
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        }

        ListNode pre = new ListNode(-1);
        ListNode dummy = new ListNode(-1);//
        ListNode curr = head;
        pre.next = curr;
        boolean currIs = false;
        int version = 0;


        while (curr != null) {
            //如果相等
            if (curr.next != null && curr.val == curr.next.val) {

                if (curr.next.next != null) {

                    curr.next = curr.next.next;
                    currIs = true;
                } else {
                    //如果后面第二个节点为null直接删掉当前的
                    //curr.next = null;  主要是要把当前的也设置为null  不然如果仅仅是把next设置为null 加假如输入只有11 会返回 1
                    curr = null;
                    pre.next = null;
                }
                //如果不相等看是否 该节点应该删除
                //删掉相等的后一个 处理相等的第一个
            } else if (currIs) {
                //忘写这个了 删掉了相等的第一个   处理完pre也要把后面的curr正确赋值
                curr = curr.next;
                //把相等的第一个也删掉
                //pre.next = curr;
                pre.next = curr;

                //要记得恢复成原来的
                currIs = false;
            } else {
                //curr = curr.next;

                //相等的处理完了 标记头结点
                if (version == 0) {
                    dummy.next = curr;
                }
                version++;
                //注意这里的顺序  下面连个如果顺序反了会导致第一个重复的会输出其中一个
                pre = curr;
                curr = curr.next;
                //pre.next = curr;

            }


            //if (!currIs) {
            //
            //    if (version == 0) {
            //        dummy.next = curr;
            //    }
            //    version++;
            //    curr = curr.next;
            //    pre.next = curr;
            //
            //}

        }

        if (version != 0) {

            return dummy.next;
        }
        return null;
    }


}
