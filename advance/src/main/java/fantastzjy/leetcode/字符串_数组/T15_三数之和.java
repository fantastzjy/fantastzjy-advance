package fantastzjy.leetcode.字符串_数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class T15_三数之和 {

    /**
     * 排序+双指针
     * 两层for循环嵌套一个判断
     * 时间复杂度 n^2   !!!!!!!!!!  内层for循环和while合并才能遍历一遍
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);  //!!!!!!!!!!!
        List<List<Integer>> ans = new ArrayList<List<Integer>>();


        // 枚举 a
        for (int first = 0; first < len; ++first) {
            // 需要和上一次枚举的数不相同！！！   第一个元素没有上一个
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = len - 1;

            //目标值
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < len; ++second) {

                // 需要和上一次枚举的数不相同！！！  且 第二层的第一个元素没有上一个
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }

                // 需要保证 b 的指针在 c 的指针的左侧 然后 右指针一直向左移动
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }

                //上面有两种情况退出while 当 third不大于second时退出的话 third和second指向同一个
                // second再往后就不会再有满足条件的  可以退出第二层循环！！！！！
                if (second == third) {
                    break;
                }

                //如果指针不重合 这里也不相等 就要等下一轮 做指针向右移动
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }


}