package fantastzjy.leetcode.BFS;


import fantastzjy.leetcode.TreeNode;

import java.util.LinkedList;

public class T111二叉树的最小深度 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 1;//别忘了根节点也代表一层
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                //最小深度是到叶子节点 "如果其中一个子树为null" 则并不是叶子节点 两个子树为null才是叶子结点!!!!!!!!!!!!!!!!
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            depth += 1;
        }
        return depth;
    }
}