package leetcode.tree.二叉搜索树BST;

import leetcode.tree.TreeNode;

public class T701二叉搜索树中的插入操作 {

    //要清楚并相信递归函数的定义
    // 向树中插入，如果该节点是null就查到这个地方，
    //           如果不为null，就往左右两边插入，插入后都变成了叶子节点
    public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right,val);
        }

        return root;
    }

}
