package leetcode.二叉树;

//用前序遍历 判断当前root节点是否等于目标节点  并不是root.val 是否等于目标节点！！！
//如果等于目标节点就返回root   如果不是就继续后序遍历
//两个都是就返回父节点  两个其中一个是 就返回其中一个子树
//最后返回的是最近的公共子节点

public class T236_二叉树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base case
        if (root == null) {
            return null;
        }
        if (root == q || root == p) {
            return root;
        }

        //后序遍历
        // 直接让子节点当做暂存节点使用 !!!!!
        root.left = lowestCommonAncestor(root.left, p, q);
        root.right = lowestCommonAncestor(root.right, p, q);

        //两个节点都不为null 则当前节点就是公共节点
        if (root.left != null && root.right != null) {
            return root;
        }
        //两个节点都为null 则当前节点和左右子节点都不包含目标节点 返回null
        if (root.left == null && root.right == null) {
            return null;
        }

        //其中一个不为null 则其中一个包含 目标节点
        return root.left == null ? root.right : root.left;
    }
}
