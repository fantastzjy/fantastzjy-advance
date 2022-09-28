package leetcode.字符串_数组;

/**
 * 思想 一层for循环   当偶数位不为偶数位时 while循环找出一个奇数位的进行交换
 */
public class T922_按奇偶排序数组II_有点纳闷 {

    public int[] sortArrayByParityII(int[] nums) {

        int j = 1;
        //注意每次都是走两步！！！
        for (int i = 0; i < nums.length; i += 2) {
            //从偶数‘序列中’找到奇数
            if (nums[i] % 2 == 1) {
                //从奇数‘序列中’找到偶数
                //找到偶数才停止，奇数的话一直寻找
                while (j < nums.length && nums[j] % 2 == 1) {
                    j += 2;
                }

                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        return nums;
    }
}

