package leetcode.二叉树;

public class T114_二叉树展开为链表 {
    public void flatten(TreeNode root) {
        // base case
        if (root == null) {
            return;
        }
        //将左、右子树变成链表
        flatten(root.left);
        flatten(root.right);
        //将左链表放到右子树
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.right = left;
        root.left = null;
        //将右子树放到左子树后面         '要相信' 左右两边都变成了只有右子树的树
        TreeNode p = root;
        //是p.right != null 不是p
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }

}
