package fantastzjy.leetcode.二叉树.二叉搜索树BST;

import fantastzjy.leetcode.TreeNode;

public class T450删除二叉搜索树中的节点 {

    //！！！！！！！！！！！！！！
    //如果直接返回  子节点  就是直接对调用他的当前节点的覆盖  当前节点就是要删除的节点直接覆盖即可
    //如果是对子节点赋值  最后在返回root就是  删除的节点不是当前节点 继续想左右子树遍历删除
    //  总结  删除、搜索 就直接覆盖（第三种情况也是转移到子树中进行时删除）  遍历就是正常对子树赋值即可

    //也可以这样理解   不陷入递归    就是删除了就返回剩下的，剩下的没有就返回null
    //当前值相等就进入执行删除   当前值不相等就接受删除之后的结果


    //前序遍历
    //前序  若找到
    //       子节点为空   return null 直接断掉
    //       左子树为空   return root.right;   让其子节点覆盖当前节点
    //       右子树为空   return root.left;    同上
    //       都不为空   让其中一个子树的叶子节点值与当前节点交换  并删除该叶子节点     注意种类不用在树化，因为不是大小顶堆

    //中序  左边找
    //后续  右边找


    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        //找到节点
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

    //！！！！！注意这里找的是右子树中的最小的   或者左子树中最大的   因为原本要删除的节点本身就比左子树大或者小
    //！！！！！所以不能找右子树中最大的，或者左子树中最小的
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
