package Leetcode.A算法.排序.桶;

import java.util.Arrays;

public class BaseSort_练习1 {
    public static void main(String[] args) {
        //int[] arr = {2, 4, 2, 3, 7, 6, 5, 4, 4, 5, 6, 8, 9, 0, 0, 9, 1, 2, 6, 5, 4, 3};
        int[] arr = {1, 12, 1, 2450, 45423, 24532, 33423, 723232, 623, 578, 478, 467, 565, 654, 843, 932, 845, 956, 987, 187, 287, 687, 576, 465, 354};
        BaseSort_练习1.baseSort(arr, findLen(arr));
        System.out.println(Arrays.toString(arr));
    }

    public static void baseSort(int[] arr, int len) {
        int[] count = new int[10];
        int[] res = new int[arr.length];
        for (int j = 0; j < len; j++) {
            int div = (int) Math.pow(10, j);

            for (int i = 0; i < arr.length; i++) {
                int num = arr[i] / div % 10;
                count[num]++;
            }

            for (int i = 1; i < 10; i++) {
                count[i] += count[i - 1];
            }

            for (int i = arr.length - 1; i >= 0; i--) {
                int num = arr[i] / div % 10;
                res[--count[num]] = arr[i];
            }

            System.arraycopy(res, 0, arr, 0, res.length);
            //一定要将 count 在初始化为0   !!!!!!!!!!!!!!!!!!!
            //不重置的话会直接导致上面的for循环中由于count[num]过大，导致res数组越界
            Arrays.fill(count, 0);
        }
    }

    public static int findLen(int[] arr) {
        int maxLen = 0;
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            temp = ("" + arr[i]).length();
            maxLen = maxLen > temp ? maxLen : temp;
        }
        return maxLen;
    }

}