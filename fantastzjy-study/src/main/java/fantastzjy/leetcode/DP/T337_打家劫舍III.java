package fantastzjy.leetcode.DP;


import fantastzjy.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

//https://leetcode-cn.com/problems/house-robber-iii/
public class T337_打家劫舍III {
    //题：所有的房屋都 在一棵树上

    //思路：根本问题就是抢与不抢的事
    //     还是一样的思路    当前加上孙子节点   或儿子节点
    //     最大值以当前节点为key存入map做备忘录

    Map<TreeNode, Integer> dp = new HashMap<>();

    public int rob(TreeNode root) {
        //base
        if (root == null) {
            return 0;
        }
        //这个加备忘录不容易想到哎
        if (dp.containsKey(root)) {
            return dp.get(root);
        }
        //rob
        int do_it = root.val
                + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right))
                + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
        //not rob
        int notdo_it = rob(root.left) + rob(root.right);
        int res = Math.max(do_it, notdo_it);
        dp.put(root, res);
        return res;
    }
}
