package leetcode.二叉树.二叉搜索树BST;

import leetcode.二叉树.TreeNode;

public class T98验证二叉搜索树_2 {
    public boolean isValidBST(TreeNode root) {

        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        //判断自己本身是否正确
        if (min != null && min.val > root.val) {
            return false;
        }
        if (max != null && max.val > max.val) {
            return false;
        }

        //判断自己的左右子树
        //return isValidBST(min, root) && isValidBST(root, max);
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);

    }

}
