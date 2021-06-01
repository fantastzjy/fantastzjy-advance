package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T15_2 {

    /**
     * 排序+双指针
     * 两层for循环嵌套一个判断
     */
    public List<List<Integer>> threeSum(int[] nums) {

        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        //第一个数
        for (int first = 0; first < len; first++) {

            //不要和前一个数重复
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            //目标值
            int target = -nums[first];
            //第三个数指针 第一个数每一次循环第三个数都从最右面往前走
            int third = len - 1;

            for (int second = first + 1; second < len; second++) {
                //防止重复
                //second >first+1
                if (second >first+1  && nums[second] == nums[second - 1]) {
                    continue;
                }

                while (second < third && nums[second] + nums[third] > target) {
                    third--;
                }

                if (second == third) {
                    break;
                }

                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    res.add(list);
                }
            }
        }

        return res;
    }
}