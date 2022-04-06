package Leetcode.二叉树;


import Leetcode.TreeNode;

public class T101_对称二叉树 {


    //宏观的去想  整体上去看！！！

    public boolean isSymmetric(TreeNode root) {
        //直接将一个二叉树比作两个二叉树
        return check(root, root);
    }

    private boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        //合并操作   判断值是否相同  不是节点p==q
        return p.val == q.val
                && check(p.left, q.right)
                && check(q.left, p.right);
    }
}


