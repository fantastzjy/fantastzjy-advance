package leetcode.二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 后续遍历二叉树_迭代 {
    private Stack<TreeNode> stk = new Stack<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        // 记录后序遍历的结果
        List<Integer> postorder = new ArrayList<>();
        TreeNode visited = new TreeNode(-1);

        pushLeftBranch(root);
        while (!stk.isEmpty()) {
            TreeNode p = stk.peek();

            if ((p.left == null || p.left == visited)
                    && p.right != visited) {
                pushLeftBranch(p.right);
            }

            if (p.right == null || p.right == visited) {
                // 后序遍历代码位置
                postorder.add(p.val);
                visited = stk.pop();
            }
        }

        return postorder;
    }

    private void pushLeftBranch(TreeNode p) {
        while (p != null) {
            stk.push(p);
            p = p.left;
        }
    }
}
