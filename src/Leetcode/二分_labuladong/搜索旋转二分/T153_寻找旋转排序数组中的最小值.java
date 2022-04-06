package Leetcode.二分_labuladong.搜索旋转二分;

//https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/

//题解见 https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/solution/yi-wen-dai-ni-gao-ding-er-fen-cha-zhao-j-00kj/
public class T153_寻找旋转排序数组中的最小值 {
    public int findMin(int[] nums) {

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {

            //情况1  直接就是有序的
            //最后是当left小于等于时 返回     注意在第三种情况 下mid+1后就进入到了右边的第一个值
            if (nums[l] <= nums[r]) {
                return nums[l];
            }

            int mid = l + (r - l) / 2;

            if (nums[l] <= nums[mid]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return -1;
    }
}