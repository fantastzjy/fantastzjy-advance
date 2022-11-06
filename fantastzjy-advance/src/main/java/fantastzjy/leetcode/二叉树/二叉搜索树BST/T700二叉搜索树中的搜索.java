package fantastzjy.leetcode.二叉树.二叉搜索树BST;

import fantastzjy.leetcode.TreeNode;

public class T700二叉搜索树中的搜索 {
    public TreeNode searchBST(TreeNode root, int val) {

        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        //直接返回就好了 ， 因为下面两种情况是二选一
        if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
    //总结：写的时候，纠结return怎么写
}
