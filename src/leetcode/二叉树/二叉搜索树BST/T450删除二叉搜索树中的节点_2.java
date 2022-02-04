package leetcode.二叉树.二叉搜索树BST;

public class T450删除二叉搜索树中的节点_2 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode min = getMin(root.right);
            int val = min.val;
            root.val = val;
            root.right = deleteNode(root.right, val);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }

        return root;

    }

    private TreeNode getMin(TreeNode node) {

        TreeNode nodetemp = node;
        if (nodetemp.left != null) {
            nodetemp = nodetemp.left;  //和链表一样，这里是向左子树递归
        }
        return nodetemp;
    }
}
