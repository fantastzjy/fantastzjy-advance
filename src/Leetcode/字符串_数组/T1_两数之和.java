package Leetcode.字符串_数组;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class T1_两数之和 {

    //二分 labauladong     不适用本题    题中是返回索引    这里使用的是二分 需要先进行排序！
    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);

        int l = 0, r = nums.length - 1;

        while (l < r) {
            if (nums[l] + nums[r] == target) {
                return new int[]{nums[l], nums[r]};
            } else if (nums[l] + nums[r] < target) {
                l++;
            } else {
                r--;
            }
        }

        return new int[0];
    }


    //哈希表
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};  //!!!!!
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }


}
