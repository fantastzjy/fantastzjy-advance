package leetcode;

public class T283_移动零 {

    //新思路  不是交换  时间直接赋值 覆盖掉
    public void moveZeroes(int[] nums) {

        int j = 0;
        //将非零全移动到左边
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }

        //将j和后面的设为零
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }

    }


    //法二  只要不为0就和左边的交换    和方法一相比就是就是多此一举  直接覆盖就好了
    public void moveZeroes2(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    //作者：LeetCode-Solution
    //链接：https://leetcode-cn.com/problems/move-zeroes/solution/yi-dong-ling-by-leetcode-solution/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

}
