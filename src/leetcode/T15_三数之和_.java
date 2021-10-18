package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class T15_三数之和_ {

    /**
     * 排序+双指针
     * 思路 两层for循环分别 控制first和second  （没戏检查是否和上次一样）  将第三个元素向前移动
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        Arrays.sort(nums);//！！！！！！！！！！！！
        int len = nums.length;

        for (int first = 0; first < len; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int third = len - 1;
            int target = -nums[first];

            for (int second = first + 1; second < len; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                while (third > second && nums[third] + nums[second] > target) {
                    third--;
                }
                if (third == second) {
                    break;
                }

                if (nums[third] + nums[second] == target) {
                    LinkedList<Integer> l = new LinkedList<>();
                    l.add(nums[first]);
                    l.add(nums[second]);
                    l.add(nums[third]);
                    ans.add(l);
                }
            }
        }
        return ans;
    }


}