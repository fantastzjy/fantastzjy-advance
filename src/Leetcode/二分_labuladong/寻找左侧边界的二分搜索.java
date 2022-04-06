package Leetcode.二分_labuladong;

public class 寻找左侧边界的二分搜索 {
    int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // 搜索区间为 [left, right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // 搜索区间变为 [mid+1, right]
                left = mid + 1;

            } else if (nums[mid] > target) {
                // 搜索区间变为 [left, mid-1]
                right = mid - 1;

                //思考：因为是要找左侧边界 所以相等的话就找左边界  那就是相当于值偏大了 就向做移动 所以right减小
            } else if (nums[mid] == target) {
                // 收缩右侧边界
                right = mid - 1;
            }
        }

        // 检查出界情况
        // 由于 while 的退出条件是 left == right + 1，所以当 target 比 nums 中所有元素都大时，会存在以下情况使得索引越界：
        //由于target一直都是大于所有元素  所以left一直向右移动  最后  left >= nums.length
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }

        return left;
    }
}
