package leetcode.树;

public class T222_完全二叉树的节点个数 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        //分两种情况
        //是否问满二叉树
        //计算左右子树的深度看是否相同
        // 由于给的是完全二叉树  必定包含一颗满二叉树 如果是就省略好多递归计算

        int left = 0, right = 0;
        TreeNode leftnNode = root, rightNode = root;  //这里一定要用一个temp node
        //while (leftnNode.left != null) {  这样写会少一层
        while (leftnNode!= null) {
            left++;
            leftnNode = leftnNode.left;
        }
        //while (rightNode.right != null) {  这样写会少一层
        while (rightNode.right != null) {
            right++;
            rightNode = rightNode.right;
        }
        if (left == right) {
            //return 1 + (int) Math.pow(2, left);
            return  (int) Math.pow(2, left)-1;  //这个计算公式根节点也算在了里面
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

}
