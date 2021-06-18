package leetcode.树;

public class T105_从前序与中序遍历序列构造二叉树 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int pl, int pr, int[] inorder, int il, int ir) {
        //base case
        // if (pl == lr) {
        //     return null;
        // }
        if (pl > pr) {
            return null;
        }

        int rootVal = preorder[pl];
        TreeNode root = new TreeNode(rootVal);
        int index = -1;
        for (int i = il; i <= ir; i++) {
            if (rootVal == inorder[i]) {
                index = i;
                break; //直接跳出
            }
        }

        //为什么这样不可以呢？
        //root.left = buildTree(preorder, pl+1,index,
        //        inorder,il,index-1);
        //root.right = buildTree(preorder, index+1,pr,
        //        inorder,index+1,ir);

        int leftsize = index - il;

        root.left = buildTree(preorder, pl + 1, pl + leftsize,
                inorder, il, index - 1);
        root.right = buildTree(preorder, pl + leftsize + 1, pr,
                inorder, index + 1, ir);

        return root;
    }
}
