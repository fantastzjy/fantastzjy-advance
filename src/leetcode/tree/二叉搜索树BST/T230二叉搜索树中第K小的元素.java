package leetcode.tree.二叉搜索树BST;


import leetcode.tree.TreeNode;

public class T230二叉搜索树中第K小的元素 {


    int res = -1, count = 0;

    public int kthSmallest(TreeNode root, int k) {

        // 利用二叉搜索树的性质 -- 左小右大
        if (root.left != null) {
            res = kthSmallest(root.left, k);
        }
        if (res == -1 && ++count == k) {
            return root.val;
        }
        if (res == -1 && root.right != null) {
            res = kthSmallest(root.right, k);
        }
        return res;
    }

}
