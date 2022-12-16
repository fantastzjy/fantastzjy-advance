package fantastzjy.leetcode.二叉树;

import fantastzjy.leetcode.TreeNode;

public class T100_相同的树 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        //basecase 都为null也代表相同
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else {
            if (p.val == q.val) {
                boolean leftTree = isSameTree(p.left, q.left);
                boolean rightTree = isSameTree(p.right, q.right);
                if (leftTree && rightTree) {
                    return true;
                }
            }
            return false;

        }
    }
    //官方合并版
    //public boolean isSameTree(TreeNode p, TreeNode q) {
    //    if (p == null && q == null) {
    //        return true;
    //    } else if (p == null || q == null) {
    //        return false;
    //    } else if (p.val != q.val) {
    //        return false;
    //    } else {
    //        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    //    }
    //}
}


