package Leetcode.二叉树.二叉搜索树BST;

import Leetcode.TreeNode;

public class T701二叉搜索树中的插入操作 {

    //要清楚并相信递归函数的定义
    // 向树中插入，如果该节点是null就查到这个地方，
    //           如果不为null，就往左右两边插入，插入后都变成了叶子节点

    //向下遍历插入的时候， 若遇到子树不为null  说明找到位置了 就插入子树中

    public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val > val) {
            //insertIntoBST(root.left, val);  也可
            root.left = insertIntoBST(root.left, val);
        } else {
            //insertIntoBST(root.right,val);   也可
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }

}
