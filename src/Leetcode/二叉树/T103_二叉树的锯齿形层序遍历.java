package Leetcode.二叉树;

import Leetcode.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class T103_二叉树的锯齿形层序遍历 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            //return null; 输出的集合类型的如果为空，不是输出为null而是输出为 []
            return res;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        boolean isleft = true;

        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            //这里用双端队列可以提供重做或者右边添加
            //但是在最后加入list队列的时候需要 转化为linkedlist在加入
            //下面直接定义成 LinkedList<TreeNode>  后面添加到res 时 直接添加就好不用转化
            Deque<Integer> list = new LinkedList<>();

            //与单纯的层级遍历输出区别是  这需要把每一层都要存储起来
            //所以没次while循环需要求出当前queue的size 然后for循环将size遍历完便结束再结束
            for (int i = 0; i < size; i++) {
                TreeNode curNode = nodeQueue.poll();
                if (isleft) {
                    list.offerLast(curNode.val);
                } else {
                    list.offerFirst(curNode.val);
                }

                if (curNode.left != null) {
                    nodeQueue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    nodeQueue.offer(curNode.right);
                }

            }
            //加入list队列的时候需要   deque类型的list 转化为linkedlist在加入
            res.add(new LinkedList<>(list));
            isleft = !isleft;
        }
        return res;
    }

    //复杂度分析
    //时间复杂度：O(N)，其中 N 为二叉树的节点数。每个节点会且仅会被遍历一次。
    //空间复杂度：O(N)。我们需要维护存储节点的队列和存储节点值的‘双端队列‘，空间复杂度为 O(N)。

}