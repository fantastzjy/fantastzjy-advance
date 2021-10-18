package leetcode.二叉树;
//链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/solution/you-xu-lian-biao-zhuan-huan-er-cha-sou-suo-shu-1-3/

public class T109_有序链表转换二叉搜索树 {

    //法一：分治
    class Solution {
        public TreeNode sortedListToBST(ListNode head) {
            return buildTree(head, null);
        }

        public TreeNode buildTree(ListNode left, ListNode right) {
            if (left == right) {
                return null;
            }
            ListNode mid = getMedian(left, right);
            TreeNode root = new TreeNode(mid.val);
            root.left = buildTree(left, mid);
            root.right = buildTree(mid.next, right);
            return root;
        }

        public ListNode getMedian(ListNode left, ListNode right) {
            ListNode fast = left;
            ListNode slow = left;
            while (fast != right && fast.next != right) {
                fast = fast.next;
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        }
    }


    class ListNode {
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

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}
