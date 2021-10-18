package leetcode.二叉树.二叉搜索树BST;

import leetcode.二叉树.TreeNode;

public class T700二叉搜索树中的搜索_2 {
    public TreeNode searchBST(TreeNode root, int val) {

        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
    //总结：写的时候，纠结return怎么写
}
