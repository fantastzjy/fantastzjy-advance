package leetcode.tree.二叉搜索树BST;

import leetcode.tree.TreeNode;

public class T98验证二叉搜索树 {
    public boolean isValidBST(TreeNode root) {

        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            //return false;
            return true;  //注意这个
        }
        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);

    }
}
