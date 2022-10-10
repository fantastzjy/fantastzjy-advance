package fantastzjy.leetcode.字符串_数组;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T1_两数之和_拓展 {

    //多个答案 去除重复

    public List<int[]> twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        //!!
        List<int[]> res = new ArrayList<>();
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int sum = nums[l] + nums[r];
            int left = nums[l], right = nums[r];
            if (sum == target) {
                res.add(new int[]{nums[l], nums[r]});//!!
                while (l < r && nums[l] == left) l++;
                while (l < r && nums[r] == right) r--;
            } else if (sum < target) {
                while (l < r && nums[l] == left) l++;
            } else {
                while (l < r && nums[r] == right) r--;
            }
        }

        return res;
    }


}
