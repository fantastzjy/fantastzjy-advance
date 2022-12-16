package fantastzjy.leetcode.二叉树;

import fantastzjy.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class T662_二叉树最大宽度_bfs_练习 {
    // Leetcode 662. Maximum Width of Binary Tree
    // @爱学习的饲养员
    // BFS
    // N is the size of Tree
    // Time Compelxity: O(N)
    // Space Complexity: O(N)
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> iq = new LinkedList<>();
        q.add(root);
        iq.add(1);
        int max = 1;
        while (q.size() > 0) {
            int size = q.size();

            int index = iq.peek();
            int initindex = index;

            while (size > 0) {
                TreeNode cur = q.poll();
                index = iq.poll();

                if (cur != null) {
                    if (cur.left != null) {
                        q.add(cur.left);
                        iq.add(index * 2);
                    }
                    if (cur.right != null) {
                        q.add(cur.right);
                        iq.add(index * 2 + 1);
                    }
                }
                size--;
            }
            max = max > index - initindex + 1 ? max : index - initindex + 1;
        }
        return max;
    }
}