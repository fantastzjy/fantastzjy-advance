package leetcode.树;

public class T116_填充每个节点的下一个右侧节点指针 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }


    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        //跨父节点了 一个参数（一个节点）解决不了   升级成连个参数（传入两个节点）
        connectTwo(root.left, root.right);
        return root;

    }

    private void connectTwo(Node left, Node right) {
        if (left == null || right == null) {
            return;
        }
        //将左右节点连接  注意是 left.next
        left.next = right;

        //将左右子树的节点各自连接
        connectTwo(left.left, left.right);
        connectTwo(right.left, right.right);

        //跨节点
        connectTwo(left.right, right.left);

    }

}
