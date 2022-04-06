package Leetcode.二叉树.二叉搜索树BST;

import Leetcode.TreeNode;

public class T450删除二叉搜索树中的节点_2 {

    public TreeNode deleteNode(TreeNode root, int key) {

        //归根到底还是个前序遍历

        if (root == null) {
            return null;
        }

        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            }

            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            TreeNode last = getNode(root.right);
            int lastVal = last.val;
            root.val = lastVal;
            root.right = deleteNode(root.right, lastVal);

        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }

        return root;
    }


    //注意这里找的是右子树中的最小的   或者左子树中最大的   因为原本要删除的节点本身就比左子树大或者小
    // 所以不能找右子树中最大的，或者左子树中最小的
    private TreeNode getNode(TreeNode right) {
        while (right.left != null) {
            right = right.left;
        }
        return right;
    }
}
