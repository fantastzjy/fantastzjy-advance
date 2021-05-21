package leetcode.tree.二叉搜索树BST;

import leetcode.tree.TreeNode;

public class T450删除二叉搜索树中的节点 {

    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) {
            return null;
        }

        if (root.val == key) {
            //三种情况
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            //从右边找一个最小的当做 根节点
            TreeNode min = getMin(root.right);
            root.val = min.val;
            root.right = deleteNode(root.right, min.val);

        } else if (root.val < key) {

            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {

            root.left = deleteNode(root.left, key);
        }
        return root;
    }

    //函数是为了找右子树中最小的，本来传进去的是右子树的根节点，
    private TreeNode getMin(TreeNode node) {
        //当 node.left == null 的时候  就找到了右子树中最小的值
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }




}
