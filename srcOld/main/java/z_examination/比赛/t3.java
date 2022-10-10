package z_examination.比赛;

import java.util.LinkedList;
import java.util.Queue;

public class t3 {


    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {

        int i = find(original, target);
        return find2(cloned, i);
    }


    int find(TreeNode root, TreeNode target) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr == target) {
                return curr.val;
            }

            if (curr.left != null) {
                queue.offer(curr.left);
            }
            if (curr.right != null) {
                queue.offer(curr.right);
            }
        }
        return -1;
    }

    TreeNode find2(TreeNode root, int target) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr.val == target) {
                return curr;
            }

            if (curr.left != null) {
                queue.offer(curr.left);
            }
            if (curr.right != null) {
                queue.offer(curr.right);
            }
        }
        return null;
    }


}