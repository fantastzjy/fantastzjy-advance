package leetcode.字符串_数组.双指针;

public class T80_删除有序数组中的重复项II {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int slow = 2, fast = 2;
        while (fast < n) {
            //这里是  slow - 2 与 fast 位置相比较
            //fast若与slow-2 相等，则相等的的元素至少有三个   每次都是对nums[slow]赋值
            //     若是fast-2与fast元素比较 会导致11122  当到第二个 2 时会认为前年已经有两个了 因为第三个1已经变成了2
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        //让返回的是新长度 所以slow不用-1
        //return slow - 1;
        return slow;
    }
}
//   ：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/solution/shan-chu-pai-xu-shu-zu-zhong-de-zhong-fu-yec2/