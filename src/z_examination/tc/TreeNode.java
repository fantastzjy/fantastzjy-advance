package z_examination.tc;

/**
 * @Package: 笔试.tc
 * @ClassName: TreeNode
 * @Author: jiaying2.zhang
 * @CreateTime: 2022-1-7 16:37
 * @Description:
 */

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
