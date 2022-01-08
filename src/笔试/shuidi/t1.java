package 笔试.shuidi;

import leetcode.二叉树.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class t1 {

    public int[][] levelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<int[]> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int max = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int[] arr = new int[size];
            max = Math.max(max, size);


            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                arr[i] = poll.val;
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            res.add(arr);
        }
        int[][] ints = new int[res.size()][max];

        return res.toArray(ints);

    }

}
