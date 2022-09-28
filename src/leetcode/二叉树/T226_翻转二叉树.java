package leetcode.二叉树;


import leetcode.TreeNode;

public class T226_翻转二叉树 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        //前序遍历位置
        //反转当前节点
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        //翻转子节点
        invertTree(root.left);
        invertTree(root.right);

        return root;

    }
}
