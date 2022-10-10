package z_examination.tc;

/**
 * @Package: 笔试.tc
 * @ClassName: ListNode
 * @Author: jiaying2.zhang
 * @CreateTime: 2022-1-7 11:42
 * @Description:
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}