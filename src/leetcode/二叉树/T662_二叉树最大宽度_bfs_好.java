package leetcode.二叉树;

import java.util.LinkedList;
import java.util.Queue;

public class T662_二叉树最大宽度_bfs_好 {
    // Leetcode 662. Maximum Width of Binary Tree
    // @爱学习的饲养员
    //https://www.bilibili.com/video/BV1Bv411j76y?from=search&seid=10950852618771705316&spm_id_from=333.337.0.0
    // BFS
    //思路： 在遍历二叉树的时候同时构建一个索引树
    // 建立两个queue，存节点和当前节点的索引
    // 不是真的去构建索引树 利用父子节点关系计算出索引存入即可

    // N is the size of Tree
    // Time Compelxity: O(N)
    // Space Complexity: O(N)
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> indexQ = new LinkedList<>();
        int result = 0;

        q.add(root);
        indexQ.add(1);
        while (!q.isEmpty()) {
            int levelSize = q.size();
            //没进入循环前先记录下初始位置的index  末尾的index每次在循环中更新
            int initialIndex = indexQ.peek();  //这里不取出来  在里面还要根据index计算要存入的index
            int index = initialIndex;
            while (levelSize > 0) {
                TreeNode cur = q.poll();
                index = indexQ.poll();
                if (cur != null) {
                    if (cur.left != null) {
                        q.add(cur.left);
                        indexQ.add(index * 2);
                    }
                    if (cur.right != null) {
                        q.add(cur.right);
                        indexQ.add(index * 2 + 1);
                    }
                }
                levelSize--;
            }
            int width = index - initialIndex + 1;
            result = Math.max(result, width);
        }
        return result;
    }
}