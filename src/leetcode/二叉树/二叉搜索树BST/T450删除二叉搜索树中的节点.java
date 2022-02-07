package leetcode.二叉树.二叉搜索树BST;
import leetcode.TreeNode;

public class T450删除二叉搜索树中的节点 {

    //！！！！！！！！！！！！！！
    //如果直接返回  子节点  就是直接对调用他的节点直接覆盖  当前节点就是要删除的节点直接覆盖即可
    //如果是对子节点赋值  最后在返回root就是  删除的节点不是当前节点 继续想左右子树遍历删除
    //  总结  删除、搜索 就直接覆盖（第三种情况也是转移到子树中进行时删除）  遍历就是正常对子树赋值即可
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            //三种情况
            //1、都为null
            if (root.left == null && root.right == null) {
                return null;
            }
            //2、其中一个为null
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            //3、都不为null
            //从右边找一个最小的当做 根节点
            TreeNode min = getMin(root.right);
            root.val = min.val;
            root.right = deleteNode(root.right, min.val);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }

    //函数是为了找右子树中最小的，本来传进去的是右子树的根节点，
    private TreeNode getMin(TreeNode node) {
        //和链表一样，这里是向左子树递归  这里原来树不会被覆盖  只是引用指向子树了
        // 假如是root.left=root.left.left 这样才会改变   与链表类似
        // 其实都是对对象的引用变了   对象内部左右子树的指针没改变   ！！！！！！！！！！！！！！！！
        //当 node.left == null 的时候  就找到了右子树中最小的值

        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
