package leetcode;

public class T110_平衡二叉树 {
    //方法一：自顶向下的递归
    //看完解答之后写出来的
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    //如果自身为null就返回0 z自身不为null就返回子节点深度加 1
    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }


    //作者：LeetCode-Solution
    //链接：https://leetcode-cn.com/problems/balanced-binary-tree/solution/ping-heng-er-cha-shu-by-leetcode-solution/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    //方法二：自底向上的递归

    //时间复杂度会减小
}
