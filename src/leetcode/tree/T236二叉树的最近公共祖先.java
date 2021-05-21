package leetcode.tree;

public class T236二叉树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base case
        if (root == null) {
            return null;
        }
        //if (root.left == null && root.right == null) {
        //    return null;
        //}
        //找到了
        if (root == q || root == p) {
            return root;
        }
        //后序遍历
        root.left = lowestCommonAncestor(root.left, p, q);
        root.right = lowestCommonAncestor(root.right, p, q);

        if (root.left != null && root.right != null) {
            return root;
        }
        if (root.left == null && root.right == null) {
            return null;
        }
        return root.left == null ? root.right : root.left;
    }
}
