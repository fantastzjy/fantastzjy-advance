package leetcode.二叉树;

import leetcode.TreeNode;


public class T236_二叉树的最近公共祖先_简化思路 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base
        if (root == null) {
            return null;
        }


        if (root == p || root == q) {
            return root;
        }
        //左子树
        TreeNode left = null;
        TreeNode right = null;
        if (root.left != null) {
            left = lowestCommonAncestor(root.left, p, q);
        }
        //右子树
        if (root.right != null) {
            right = lowestCommonAncestor(root.right, p, q);
        }
        //  都没有
        if (left == null && right == null) {
            return null;
        }
        //两数都有
        if (left != null && right != null) {
            return root;
        }

        //其中一个有
        return left != null ? left : right;

    }
}
