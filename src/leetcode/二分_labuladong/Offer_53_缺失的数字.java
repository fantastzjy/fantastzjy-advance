package leetcode.二分_labuladong;

public class Offer_53_缺失的数字 {
    //一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
    // 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。

    //链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof

//思考 有序 --> 二分法

    public static void main(String[] args) {
        System.out.println(4 >> 1);  //2
        System.out.println(4 & 4);   //4
        System.out.println(4 & (4 - 1));   //0
        System.out.println(Offer_53_缺失的数字.missingNumber(new int[]{0, 1, 3})); //2

    }

    public static int missingNumber(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {

            //int m = l + (r - l) >> 1;    //为何位运算不可以呢？？？？？
            int m = l + (r - l) / 2;

            if (nums[m] == m) {
                l = m + 1;
            } else {
                r = m - 1;
            }

        }

        return l;

    }
}