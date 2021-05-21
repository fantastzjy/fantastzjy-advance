package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class 层级遍历二叉树 {


    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            System.out.println(curr.val);

            if (curr.left != null) {
                queue.offer(curr.left);
            }
            if (curr.right != null) {
                queue.offer(curr.right);
            }

        }
    }

    //层级遍历序列化
    String serialized(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll == null) {
                stringBuilder.append("null").append(",");
                ;
                continue;
            }
            stringBuilder.append(poll.val).append(",");
            queue.offer(poll.left);
            queue.offer(poll.right);

        }
        return stringBuilder.toString();

    }

    //层级遍历的反序列化
    TreeNode deserialized(String data) {
        if (data == null || "".equals(data)) {
            return null;
        }
        String[] splits = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(splits[0]));
        queue.offer(root);

        int length = data.length();
        int i=1;
        while ( i <length) {
            TreeNode parent = queue.poll();
            //String left = splits[i++];
            if (splits[i] != null) {
                parent.left = new TreeNode(Integer.parseInt(splits[i++]));
                queue.offer(parent.left);
            } else {
                parent.left = null;
                i++;
            }
            //String right = splits[i++];
            if (splits[i] != null) {
                parent.right = new TreeNode(Integer.parseInt(splits[i++]));
                queue.offer(parent.right);
            } else {
                parent.right = null;
                i++;
            }

        }

        return root;

    }


}
