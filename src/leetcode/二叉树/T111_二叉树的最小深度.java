package leetcode.二叉树;


public class T111_二叉树的最小深度 {

    public int minDepth(TreeNode root) {
        int mindept = Integer.MAX_VALUE;
        // 这里不能取消判断根节点是否为空的判断  因为下面需要用到root的左右节点
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            //注意这里   左右子树如果都为空 深度应该是 1
            return 1;
        }

        //若其中一个子树为null 在进入minDepth方法时自动返回长度为 0
        if (root.left != null) {
            mindept = Math.min(minDepth(root.left), mindept);
            //} else if (root.right != null) {   判断完左子树之后不能在else if右子树 如果左子树宾利到根本不会计算右子树的深度
        }
        if (root.right != null) {
            mindept = Math.min(minDepth(root.right), mindept);
        }
        //深度应该加上父节点和字数的这一层
        return mindept + 1;
    }


}