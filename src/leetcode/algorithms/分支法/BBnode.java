package leetcode.algorithms.分支法;

/**
 * 分支界限节点
 */
public class BBnode {
    BBnode parent; // 父节点
    boolean leftChild; // 左孩子标识

    public BBnode(BBnode parent, boolean leftChild) {
        this.parent = parent;
        this.leftChild = leftChild;
    }
}