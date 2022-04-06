package Leetcode.二叉树;

import Leetcode.TreeNode;

//https://leetcode-cn.com/problems/maximum-binary-tree/
public class T654_最大二叉树_频率_忽略 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        return MaximumBinaryTree(nums, 0, nums.length - 1);
    }

    private TreeNode MaximumBinaryTree(int[] nums, int l, int r) {
        //base case
        if (l > r) {
            return null;
        }
        int index = -1, max = Integer.MIN_VALUE;
        //前序遍历位置
        for (int i = l; i <= r; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }

        TreeNode root = new TreeNode(max);
        //中后序遍历位置
        root.left = MaximumBinaryTree(nums, l, index - 1);
        root.right = MaximumBinaryTree(nums, index + 1, r);

        return root;
    }


    //复杂度分析??????
    //时间复杂度：O(n^2)
    //空间复杂度：O(n)
}
