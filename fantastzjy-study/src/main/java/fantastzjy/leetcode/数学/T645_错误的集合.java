package fantastzjy.leetcode.数学;

//https://leetcode-cn.com/problems/set-mismatch/
public class T645_错误的集合 {
    //有一个元素重复  导致一个元素缺失  找出重复的元素值  和  缺失的坐标

    //集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，
    // 导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，
    // 导致集合 丢失了一个数字 并且 有一个数字重复 。
    //链接：https://leetcode-cn.com/problems/set-mismatch

    public static void main(String[] args) {
        T645_错误的集合.findErrorNums(new int[]{
                1, 2, 2, 4});
    }

    public static int[] findErrorNums(int[] nums) {

        int dump = -1;
        for (int i = 0; i < nums.length; i++) {

            //数组中的元素值可能是负数，但是索引要正的
            int index = Math.abs(nums[i]) - 1;

            if (nums[index] > 0) {
                nums[index] *= -1;
            } else {
                //找到的话不在变成正的，便于从没有变化的正数中查找 缺失的数
                dump = index + 1;
            }
        }

        int miss = -1;
        for (int i = 0; i < nums.length; i++) {
            //此时需要的是遍历一遍找到正数 再加1 不是找到映射的那个位置
            //int index = Math.abs(nums[i]) - 1;
            //if (nums[index] > 0) {
            //    miss = index + 1;
            //}

            if (nums[i] > 0) {
                miss = i + 1;
            }
        }

        return new int[]{dump, miss};
    }
}