package leetcode.二叉树;


import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class 二叉树非递归写法_练习 {
    LinkedList<TreeNode> stack = new LinkedList<>();


    // 左侧树枝一撸到底
    private void pushLeftBranch(TreeNode p) {
        while (p != null) {
            //前序
            stack.push(p);
            p = p.left;
        }

    }

    public List<Integer> traverse(TreeNode root) {


        pushLeftBranch(root);
        TreeNode visited = null;

        while (!stack.isEmpty()) {

            TreeNode li = stack.peek();

            if (li.left == null || li.left == visited) {

                //中序
                pushLeftBranch(root.right);
            }
            if (li.right == null || li.right == visited) {

                //后序
                visited = stack.pop();

            }


        }


        return null;
    }


}
