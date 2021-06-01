package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T15三数之和 {

    /**
     *
     * 排序+双指针
     * 两层for循环嵌套一个判断
     *
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同！！！
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;

            //目标值
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {

                // 需要和上一次枚举的数不相同！！！  second > first + 1  为了让第二层循环的第一个元素不进行查重
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }

                // 需要保证 b 的指针在 c 的指针的左侧 然后 右指针一直向左移动
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }

                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出第二层循环！！！！！
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


    //法二  类似 两数之和

}