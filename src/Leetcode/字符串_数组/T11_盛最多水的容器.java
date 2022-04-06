package Leetcode.字符串_数组;

//题解见labuladong接雨水
public class T11_盛最多水的容器 {


    //思路：与接雨水区别在于   接雨水的柱子有宽度  这个没有宽度   面积直接就是min（高）*(right-left)
    public int maxArea(int[] height) {

        int left = 0, right = height.length - 1;
        int max = 0;

        while (left < right) {

            int t = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, t);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }

        }

        return max;

    }

}