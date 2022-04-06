package Leetcode.字符串_数组;

// https://labuladong.gitee.io/algo/4/32/129/
public class T42_接雨水_labuladong {


    //思路 双指针边走边计算
    int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int l_max = 0, r_max = 0;

        int res = 0;
        while (left < right) {

            //记录的是扫描过得最高的竹子高度
            l_max = Math.max(l_max, height[left]);
            r_max = Math.max(r_max, height[right]);

            //雨水的多少 只与两边有关系 比较的是两边最高柱子的高度
            // 矮的那一端就是可以确定那一端最多能少水
            // res += min(l_max, r_max) - height[i]
            if (l_max < r_max) {
                res += l_max - height[left];
                left++;
            } else {
                res += r_max - height[right];
                right--;
            }
        }
        return res;
    }
}