package leetcode;



public class T101_对称二叉树 {

    public boolean isSymmetric(TreeNode root) {
        //直接将一个二叉树比作两个二叉树
        return check(root, root);
    }

    private boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        //合并操作
        return p.val == q.val && check(p.left, q.right) && check(q.left, p.right);
    }

    //错误答案没写完的。。。
    //public boolean isSymmetric(TreeNode root) {
    //    if (root.left==null&&root.right==null) {
    //        return true;
    //    } else if (root.left==null||root.right==null) {
    //        return false;
    //    }else if(root.left.val==root.right.val) {
    //        isSymmetric(root.left.left);
    //        isSymmetric(root.right.right);
    //        isSymmetric(root.left.right);
    //        isSymmetric(root.left.left);
    //    }
    //}


}


