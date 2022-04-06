package Leetcode.字符串_数组.双指针;

public class T80_删除有序数组中的重复项II_法二 {
    public int removeDuplicates(int[] nums) {
        return process(nums, 2);
    }

    int process(int[] nums, int k) {
        int u = 0;
        for (int x : nums) {
            if (u < k || nums[u - k] != x) {
                nums[u++] = x;
            }
        }
        return u;
    }
}

//https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/solution/gong-shui-san-xie-guan-yu-shan-chu-you-x-glnq/

