package leetcode.字符串_数组;

public class T33_搜索旋转排序数组_优化 {

    //思路 找到有序的那一边 然后再进去判断 目标值是否在该段    因为有序才能参与比较  二分法！！！！

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid = 0;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 先根据 nums[mid] 与 nums[l] 的关系判断 mid 是在左段还是右段
            //等于要包含在左边！！！！！！！！
            if (nums[mid] >= nums[l]) {
                // 再判断 target 是在 mid 的左边还是右边，从而调整左右边界 l 和 r
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}


// https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/duo-si-lu-wan-quan-gong-lue-bi-xu-miao-dong-by-swe/
