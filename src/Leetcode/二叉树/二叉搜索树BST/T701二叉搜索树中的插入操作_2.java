package Leetcode.二叉树.二叉搜索树BST;

import Leetcode.TreeNode;

public class T701二叉搜索树中的插入操作_2 {

    //要清楚并相信递归函数的定义
    // 向树中插入，如果该节点是null就查到这个地方，
    //           如果不为null，就往左右两边插入，插入后都变成了叶子节点
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        //如果是返回子树 本轮递归的root就没了！！！！！
        //插入的递归 不是代替这个root 而是插入到子树节点中，所以还是返回‘这棵树’的’根‘节点
        //如果是搜索二叉树的话，才是返回那个节点所以要一层层的直接返回找到的节点
        if (root.val < val) {
            //return root.right = insertIntoBST(root.right, val);
            root.right = insertIntoBST(root.right, val);
        } else {
            //return root.left = insertIntoBST(root.left, val);
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }

}
