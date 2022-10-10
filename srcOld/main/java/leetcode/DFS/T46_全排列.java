package leetcode.DFS;

import java.util.ArrayList;
import java.util.List;

//使用arraylist
//时间复杂度 O n*n！    每个对于 backtrack 调用的每个叶结点（共 n! 个）
//空间复杂度 O n
public class T46_全排列 {

    List<List<Integer>> res = new ArrayList<>();
    //List<List<Integer>> res = new LinkedList<>();

    /*
     * 主函数，输入一组不重复的数字，返回它们的全排列
     */
    List<List<Integer>> permute(int[] nums) {
        // 记录「路径」
        ArrayList<Integer> track = new ArrayList<>();
        //LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    // 路径：记录在 track 中
    // 选择列表：nums 中不存在于 track 的那些元素
    // 结束条件：nums 中的元素全都在 track 中出现
    void backtrack(int[] nums, ArrayList<Integer> track) {
        // 触发结束条件
        //if (track.size() == track.size()) {  这个bug不可饶恕   敲代码时一定要小心
        if (track.size() == nums.length) {
            //res.add(track);
            // 这样不可以   这样添加进去的会只是个引用
            // 最后track 为空 res也就里面的每一个也是空  就像这样 [[],[],[],[],[],[]]
            res.add(new ArrayList<>(track)); // 要新建一个才可以 不然track 改的话就改变了  因为存入的是地址
            //res.add(new LinkedList<>(track));
            return;  //直接结束当前循环！！！！！！！！！！！！！！！！！！！！！！
        }

        for (int i = 0; i < nums.length; i++) {

            //要放在循环里面才能取到具体的那个值
            //排除不合法的选择 剪枝
            if (track.contains(nums[i])) {
                continue;
            }
            // 做选择
            track.add(nums[i]);
            // 进入下一层决策树
            backtrack(nums, track);
            // 取消选择
            //track.removeLast();//LinkedList的方法
            track.remove(track.size() - 1);//还是创建LinkedList比较方便，不用管索引
        }
    }
}
