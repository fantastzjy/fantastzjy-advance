package fantastzjy.leetcode.链表;


import fantastzjy.leetcode.ListNode;

public class T234_回文链表_递归 {
    private ListNode frontPointer;


    // 思想
    // 先将头结点进行标记  找到最后一个节点后每次与头指针 想比较   若相等则头指针向后移动   同时出一层递归！！！！！
    public boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }

    private boolean recursivelyCheck(ListNode currentNode) {
        //为null则说明到末尾
        if (currentNode != null) {
            //到底层时返回true，上面每一层会返回是否回文相等
            if (!recursivelyCheck(currentNode.next)) {
                return false;
            }
            if (currentNode.val != frontPointer.val) {
                return false;
            }
            //！！！！！
            frontPointer = frontPointer.next;
        }
        //到底层时返回true， 开始进行递归
        return true;
    }


}


//链接：https://leetcode-cn.com/problems/palindrome-linked-list/solution/hui-wen-lian-biao-by-leetcode-solution/
