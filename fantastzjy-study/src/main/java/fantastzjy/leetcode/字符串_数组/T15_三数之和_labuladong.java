package fantastzjy.leetcode.字符串_数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class T15_三数之和_labuladong {

    //解析见labuladong
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);//！！！！！！！！！！！！
        int len = nums.length;
        int target = 0;
        for (int i = 0; i < len; i++) {
            List<List<Integer>> twoRes = twosum(nums, i + 1, target - nums[i]);
            for (List<Integer> twoRe : twoRes) {
                twoRe.add(nums[i]);
                res.add(twoRe);
            }
            while (i < len - 1 && nums[i] == nums[i + 1]) i++;
        }


        return res;
    }

    private List<List<Integer>> twosum(int[] nums, int i, int target) {

        //!!
        List<List<Integer>> res = new ArrayList<>();
        int l = i, r = nums.length - 1;

        while (l < r) {
            int sum = nums[l] + nums[r];
            int left = nums[l], right = nums[r];
            if (sum == target) {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(nums[l]);
                tmp.add(nums[r]);
                res.add(tmp);//!!

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