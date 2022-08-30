package leetcode.二叉树;

//链接：https://leetcode-cn.com/problems/balanced-binary-tree/solution/ping-heng-er-cha-shu-by-leetcode-solution/

import leetcode.TreeNode;

public class T110_平衡二叉树 {
    //方法一：自顶向下的递归
    class solution1 {
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            } else {
                //自身平衡且子树也平衡
                return Math.abs(height(root.left) - height(root.right)) <= 1
                        && isBalanced(root.left) && isBalanced(root.right);
            }
        }

        //如果自身为null就返回0 z自身不为null就返回子节点深度加 1
        public int height(TreeNode root) {
            if (root == null) {
                return 0;
            } else {
                return Math.max(height(root.left), height(root.right)) + 1;
            }
        }
    }


    //方法二：自底向上的递归
    class solution2 {

        public boolean isBalanced(TreeNode root) {
            return height(root) >= 0;
        }

        public int height(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
                return -1;
            } else {
                return Math.max(leftHeight, rightHeight) + 1;
            }
        }
    }
}
