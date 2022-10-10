package leetcode.二叉树;

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class T662_二叉树最大宽度_bfs_索引_好 {
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
        indexQ.add(0);//记录每一个二叉树在树中的位置

        while (!q.isEmpty()) {
            int levelSize = q.size();
            //没进入循环前先记录下每一行的初始位置 initialIndex  末尾的index每次在循环中更新
            //这里不取出来  在里面还要根据currIndex计算要存入的currIndex
            int initialIndex = indexQ.peek();
            int currIndex = initialIndex;//要在外面定义currIndex，这里可不进行赋值

            while (levelSize > 0) {
                TreeNode cur = q.poll();
                currIndex = indexQ.poll();
                if (cur != null) {
                    if (cur.left != null) {
                        q.add(cur.left);
                        indexQ.add(currIndex * 2 + 1);
                    }
                    if (cur.right != null) {
                        q.add(cur.right);
                        indexQ.add(currIndex * 2 + 2);
                    }
                }
                levelSize--;
            }
            int width = currIndex - initialIndex + 1;
            result = Math.max(result, width);
        }
        return result;
    }
}