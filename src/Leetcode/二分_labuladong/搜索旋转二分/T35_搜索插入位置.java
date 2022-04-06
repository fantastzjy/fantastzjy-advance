package Leetcode.二分_labuladong.搜索旋转二分;

public class T35_搜索插入位置 {


    public int searchInsert(int[] nums, int target) {
        //思路 和二分一样   不过要返回left
        //因为mid的计算  /2   时mid总是小的
        int len = nums.length;
        //base
        if (len == 0) {
            return -1;
        }

        int l = 0, r = len - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;

    }
}