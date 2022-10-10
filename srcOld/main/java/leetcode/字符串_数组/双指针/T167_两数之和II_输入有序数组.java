package leetcode.字符串_数组.双指针;

public class T167_两数之和II_输入有序数组 {

    //就是二分的思想 让左右指针移动即可  不要硬搬套路
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1};
    }
}