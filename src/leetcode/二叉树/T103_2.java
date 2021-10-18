package leetcode.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class T103_2 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }

        List res = new ArrayList<Integer>();
        boolean islift = true;

        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);

        while (!nodes.isEmpty()) {
            int size = nodes.size();
            LinkedList<Integer> arr = new LinkedList<>();
            while (size > 0) {
                TreeNode node = nodes.poll();
                if (islift) {
                    arr.addLast(node.val);
                } else {
                    arr.addFirst(node.val);
                }

                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
                size--;
            }
            res.add(arr);
            islift = !islift;
        }
        return res;
    }
}