package leetcode.树.二叉树序列化;

import leetcode.树.TreeNode;

import java.util.LinkedList;

public class T297二叉树的序列化与反序列化 {
    //总结


    String sep = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);

        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        //base case
        if (root == null) {
            sb.append("null").append(sep);
            return;  //记得中断
        }
        sb.append(root.val).append(sep);

        serialize(root.left, sb);
        serialize(root.right, sb);

    }


    //// Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //一定要先加判断
        if (data == null || "".equals(data)) {
            return null;
        }
        LinkedList<String> linkedList = new LinkedList<>();
        String[] split = data.split(sep);
        for (String s : split) {
            linkedList.add(s);
        }
        return deserialize(linkedList);
    }

    //优化分析
    // 在 deserialize(String data) 中  LinkedList<Integer>  里面类型是string就行 在最后放入树中在转化
    //这样可以省略好多步骤   而且节约好多时间


    private TreeNode deserialize(LinkedList<String> linkedList) {
        //base case
        if (linkedList.isEmpty()) {
            return null;
        }

        //合并到下面
        //if ("null".equals(linkedList.getFirst())) {
        //    linkedList.removeFirst();  //别忘了移除
        //    return null;
        //}

        String rootVal = linkedList.removeFirst();
        if ("null".equals(rootVal)) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(rootVal));

        root.left = deserialize(linkedList);
        root.right = deserialize(linkedList);
        return root;
    }


    //// Decodes your encoded data to tree.
    //public TreeNode deserialize(String data) {
    //
    //    if (data == null || "".equals(data)) {
    //        return null;
    //    }
    //    LinkedList<Integer> linkedList = new LinkedList<Integer>();
    //    String[] split = data.split(sep);
    //    for (String s : split) {
    //        if (!s.equals("null")) {
    //
    //            linkedList.add(Integer.valueOf(s));
    //        } else {
    //            linkedList.add(null);
    //        }
    //
    //    }
    //    TreeNode root = deserialize(linkedList);
    //
    //    return root;
    //}
    //
    //优化分析
    // 在 deserialize(String data) 中  LinkedList<Integer>  里面类型是string就行 在最后放入树中在转化
    //这样可以省略好多步骤
    //
    //
    //private TreeNode deserialize(LinkedList<Integer> linkedList) {
    //    //base case
    //    if (linkedList.isEmpty()) {
    //        return null;
    //    }
    //    //if (linkedList.getFirst().equals(null)) {    会出现空指针异常
    //    if (linkedList.getFirst() == null) {
    //        linkedList.removeFirst();  //别忘了移除
    //        return null;
    //    }
    //    int rootVal = linkedList.removeFirst();
    //
    //    TreeNode root = new TreeNode(rootVal);
    //
    //    root.left = deserialize(linkedList);
    //    root.right = deserialize(linkedList);
    //    return root;
    //}


}
