package fantastzjy.leetcode.链表;


import fantastzjy.leetcode.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

//  优先队列    队列中放入的是头结点 每次拿出来一个头结点后 将next结点再放入
//时间
public class T23_合并K个升序链表_labuladong {


    public static void main(String[] args) {
        //new T23_合并K个升序链表_labuladong().mergeKLists([[],[]]);

    }

    public ListNode mergeKLists(ListNode[] lists) {
        //basecase
        if (lists == null || lists.length == 0) {
            return null;
        }

        //lists.length  长度不用-1    若长度写成 lists.length-1  则用例 [[]]   会报错  why？？？
        Queue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> {
            return a.val - b.val;
        });

        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }

        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while (!pq.isEmpty()) {
            ListNode poll = pq.poll();
            tail.next = poll;
            tail = tail.next;
            if (poll.next != null) {
                pq.offer(poll.next);
            }
        }

        return dummy.next;

    }

}
