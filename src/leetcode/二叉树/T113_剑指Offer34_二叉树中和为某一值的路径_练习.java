package leetcode.二叉树;

import leetcode.TreeNode;

import java.util.*;

//注意到本题的要求是，找到所有满足从「根节点」到某个「叶子节点」经过的路径上的节点之和等于目标和的路径
public class T113_剑指Offer34_二叉树中和为某一值的路径_练习 {

    //思考  二叉树的dfs遍历  还是用的是前序遍历的框架 加上dfs的最后的撤销选择！！！
    //dfs
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new LinkedList<>();


        public List<List<Integer>> pathSum(TreeNode root, int target) {
            dfs(root, target);
            return res;
        }

        private void dfs(TreeNode root, int target) {
            if (root == null) {
                return;
            }
            //basecase
            //路径记录的是值 并不是节点
            path.offerLast(root.val);
            target -= root.val;

            if (root.left == null && root.right == null && target == 0) {
                res.add(new LinkedList<>(path));  //创建新集合都可以把自身类型的集合当做参数传进来 集合中的元素都添加进来
            }

            dfs(root.left, target);
            dfs(root.right, target);

            path.pollLast();
        }

    }

    //链接：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/solution/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-68dg/

    //bfs    还没练习
    class Solution2 {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        Map<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();

        public List<List<Integer>> pathSum(TreeNode root, int target) {
            if (root == null) {
                return ret;
            }

            Queue<TreeNode> queueNode = new LinkedList<TreeNode>();
            Queue<Integer> queueSum = new LinkedList<Integer>();
            queueNode.offer(root);
            queueSum.offer(0);

            while (!queueNode.isEmpty()) {
                TreeNode node = queueNode.poll();
                int rec = queueSum.poll() + node.val;

                if (node.left == null && node.right == null) {
                    if (rec == target) {
                        getPath(node);
                    }
                } else {
                    if (node.left != null) {
                        map.put(node.left, node);
                        queueNode.offer(node.left);
                        queueSum.offer(rec);
                    }
                    if (node.right != null) {
                        map.put(node.right, node);
                        queueNode.offer(node.right);
                        queueSum.offer(rec);
                    }
                }
            }

            return ret;
        }

        public void getPath(TreeNode node) {
            List<Integer> temp = new LinkedList<Integer>();
            while (node != null) {
                temp.add(node.val);
                node = map.get(node);
            }
            Collections.reverse(temp);
            ret.add(new LinkedList<Integer>(temp));
        }
    }

}

