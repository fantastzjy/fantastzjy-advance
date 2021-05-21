package leetcode.双指针技巧;

public class T26删除有序数组中的重复项 {
    public int removeDuplicates(int[] nums) {
        int slow = 0, fast = 0;

        while (fast < nums.length) {


            if (nums[slow] == nums[fast]) {
                fast++;
            } else {
                nums[++slow] = fast;
            }
        }

        return slow + 1;
    }
}
