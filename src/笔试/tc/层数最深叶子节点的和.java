package 笔试.tc;

import java.util.LinkedList;

/**
 * @Package: 笔试.tc
 * @ClassName: 层数最深叶子节点的和
 * @Author: jiaying2.zhang
 * @CreateTime: 2022-1-7 16:37
 * @Description:
 */
public class 层数最深叶子节点的和 {
    public int deepestLeavesSum(TreeNode root) {

        LinkedList<TreeNode> l = new LinkedList<>();
        l.add(root);
        int res = 0;
        int tem = 0;
        while (!l.isEmpty()) {
            tem = 0;
            int size = l.size();
//            int tem = 0;
            while (size > 0) {
                TreeNode poll = l.poll();
                if (poll.left != null) {
                    l.add(poll.left);
                }
                if (poll.right != null) {
                    l.add(poll.right);
                }
                tem += poll.val;
                size--;
            }
//            res = res > tem ? res : tem;
        }

        return tem;
    }
}