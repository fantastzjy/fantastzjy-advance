package leetcode.二叉树;

import leetcode.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//与上面的一样    创建新集合都可以把自身类型的集合当做参数传进来 集合中的元素都添加进来
public class T113_路径总和II {

    List<List<Integer>> ret = new LinkedList<List<Integer>>();
    Deque<Integer> path = new LinkedList<Integer>();


    //要递归调用 但是不需要每次都返回结果  所以另外写一个方法
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return null;
        }
        dfs(root, targetSum);
        return ret;
    }

    public void dfs(TreeNode root, int targetSum) {
        //basecase
        //if (root == null) {
        //    return;
        //}
        path.offerLast(root.val);
        targetSum -= root.val;   //对元素的处理  直接减去该值！！！！！！！！！！！！ 然后判断是否满足条件
        if (root.left == null && root.right == null && targetSum == 0) {
            ret.add(new LinkedList<Integer>(path));
        }

        //做选择   这里把做判断右子树是否为null放到了basecase里面
        if (root.left != null) {
            dfs(root.left, targetSum);
        }
        if (root.right != null) {
            dfs(root.right, targetSum);
        }
        //dfs(root.left, targetSum);
        //dfs(root.right, targetSum);


        //撤销选择
        path.pollLast();
    }
}

//   https://leetcode-cn.com/problems/path-sum-ii/solution/lu-jing-zong-he-ii-by-leetcode-solution/