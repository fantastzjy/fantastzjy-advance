package leetcode.tree.二叉搜索树BST;

import leetcode.tree.TreeNode;

public class T538把二叉搜索树转换为累加树 {

    //把中序遍历反过来即可
    int res = 0;

    public TreeNode convertBST(TreeNode root) {
        //base case
        if (root == null) {
            return null;
        }
        //右
        root.right = convertBST(root.right);
        //中
        root.val = res += root.val;
        //左
        root.left = convertBST(root.left);

        return root;
    }


}
