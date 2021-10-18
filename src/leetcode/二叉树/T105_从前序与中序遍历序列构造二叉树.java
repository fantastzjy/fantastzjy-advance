package leetcode.二叉树;

public class T105_从前序与中序遍历序列构造二叉树 {
    //  [1],[2,4,7],[3,5,6,8]
    //  [4,7,2],[1],[5,3,8,6]

    //给定方法参数不够  增加参数
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preOrder, int preL, int preR, int[] midOrder, int midL, int midR) {
        //base case  边界的处理
        if (preL > preR) {
            return null;
        }

        int rootVal = preOrder[preL];
        TreeNode root = new TreeNode(rootVal);

        int midIndex = midL;
        //直接while循环就行  题意就是一定能找到
        while (midOrder[midIndex] != rootVal) {
            midIndex++;
        }
        //for (int i = midL; i <= midR; i++) {
        //    if (rootVal == midOrder[i]) {
        //        midIndex = i;
        //        break; //直接跳出
        //    }
        //}


        //不用加1 因为左子树的长度正好要去掉中间元素 也就是减1    正常情况下计算长度 是 right-left+1
        int leftSize = midIndex - midL;

        //左子树
        //前序边界 左子树是 不包含子一个元素
        //中序边界 包含中间元素的左右边界   也就是中序遍历的左子树部分的边界
        root.left = buildTree(preOrder, preL + 1, preL + leftSize,
                midOrder, midL, midIndex - 1);
        //右子树
        root.right = buildTree(preOrder, preL + leftSize + 1, preR,
                midOrder, midIndex + 1, midR);

        return root;
    }
}
