package leetcode.二叉树;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class T662_二叉树最大宽度 {
    //方法框架
    //        解释
    //由于我们需要将给定树中的每个节点都访问一遍，我们需要遍历树。我们可以用深度优先搜索或者宽度优先搜索将树遍历。

    //这个问题中的主要想法是给每个节点一个 position 值，
    // 如果我们走向左子树，那么 position -> position * 2，
    // 如果我们走向右子树，那么 position -> positon * 2 + 1。
    // 当我们在看同一层深度的位置值 L 和 R 的时候，宽度就是 R - L + 1。


    //bfs
    //时间复杂度： O(N)，其中 N 是输入树的节点数目，我们遍历每个节点一遍。
    //空间复杂度： O(N)，这是 queue 的大小。

    //宽度优先搜索顺序遍历每个节点的过程中，我们记录节点的 position 信息，
    // 对于每一个深度，第一个遇到的节点是最左边的节点，最后一个到达的节点是最右边的节点。
    class Solution {
        public int widthOfBinaryTree(TreeNode root) {
            Queue<AnnotatedNode> queue = new LinkedList();
            queue.add(new AnnotatedNode(root, 0, 0));
            int curDepth = 0, left = 0, ans = 0;
            while (!queue.isEmpty()) {
                AnnotatedNode a = queue.poll();
                if (a.node != null) {
                    queue.add(new AnnotatedNode(a.node.left, a.depth + 1, a.pos * 2));
                    queue.add(new AnnotatedNode(a.node.right, a.depth + 1, a.pos * 2 + 1));
                    //判断是否进入的是新的一层 及时记录最左边的边界
                    if (curDepth != a.depth) {
                        curDepth = a.depth;
                        left = a.pos;
                    }
                    ans = Math.max(ans, a.pos - left + 1);
                }
            }
            return ans;
        }
    }

    class AnnotatedNode {
        TreeNode node;
        int depth, pos;

        AnnotatedNode(TreeNode n, int d, int p) {
            node = n;
            depth = d;
            pos = p;
        }
    }

    //链接：https://leetcode-cn.com/problems/maximum-width-of-binary-tree/solution/er-cha-shu-zui-da-kuan-du-by-leetcode/

    //dfs
    //时间复杂度： O(N) ，其中 N 是树中节点的数目，我们需要遍历每个节点。
    //空间复杂度： O(N) ，这部分空间是因为我们 DFS 递归过程中有 N  层的栈。

    //按照深度优先的顺序，我们记录每个节点的 position 。
    //对于每一个深度，第一个到达的位置会被记录在 left[depth] 中。
    //然后对于每一个节点，它对应这一层的可能宽度是 pos - left[depth] + 1 。我们将每一层这些可能的宽度去一个最大值就是答案。
    class Solution2 {
        int ans;
        Map<Integer, Integer> left;

        public int widthOfBinaryTree(TreeNode root) {
            ans = 0;
            left = new HashMap();
            dfs(root, 0, 0);
            return ans;
        }

        public void dfs(TreeNode root, int depth, int pos) {
            if (root == null) return;
            left.computeIfAbsent(depth, x -> pos);
            ans = Math.max(ans, pos - left.get(depth) + 1);
            dfs(root.left, depth + 1, 2 * pos);
            dfs(root.right, depth + 1, 2 * pos + 1);
        }
    }

}
