package leetcode.二分_labuladong;

/**
 * 有一个整型数组，数组元素不重复，数组元素先升序后降序，找出最大值。
 */
public class 数组的最大值 {
    public static void main(String[] args) {

        int[] nums = {1, 3, 5, 7, 9, 8, 6, 4, 2};
        System.out.println(getLargestNumInArray(nums));
    }

    private static int getLargestNumInArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) / 2);

            //比较的条件 比较的是  mid 与 mid+1
            // 若小于    则向右平衡
            // 若大于等于    即 mid>=mid+1  则向左平衡  即向左寻找
            //最后为什么返回的是left呢  因为当 < 时  回将left移动到比小于大一位的位置   最后一定是 left
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return nums[left];
    }
}