package fantastzjy.leetcode.DFS;

import java.util.LinkedList;
import java.util.List;

//使用linkedlist
public class T46_2 {

    List<List<Integer>> res = new LinkedList<>();

    /*
     * 主函数，输入一组不重复的数字，返回它们的全排列
     */
    List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(track, nums);
        return res;
    }

    private void backtrack(LinkedList<Integer> track, int[] nums) {

        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));   //如果直接加入 在改变track的话九夜茴改变   存入的只是地址
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (track.contains(nums[i])) {
                continue;
            }
            track.add(nums[i]);
            backtrack(track, nums);
            track.removeLast();
        }
    }


}
