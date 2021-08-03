package leetcode.a算法.排序;

import java.util.Arrays;

public class BaseSort {

    public static void main(String[] args) {
        //int[] arr = {2, 4, 2, 3, 7, 6, 5, 4, 4, 5, 6, 8, 9, 0, 0, 9, 1, 2, 6, 5, 4, 3};
        int[] arr = {1, 12, 1, 2450, 45423, 24532, 33423, 723232, 623, 578, 478, 467, 565, 654, 843, 932, 845, 956, 987, 187, 287, 687, 576, 465, 354};
        BaseSort.baseSort(arr, findLen(arr));
        System.out.println(Arrays.toString(arr));
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

    public static void baseSort(int[] arr, int maxLen) {
        int[] result = new int[arr.length];
        int[] count = new int[10];


        for (int i = 0; i < maxLen; i++) {
            int division = (int) Math.pow(10, i);
            for (int j = 0; j < arr.length; j++) {
                int num = arr[j] / division % 10;
                count[num]++;
            }

            for (int j = 1; j < count.length; j++) {
                count[j] = count[j] + count[j - 1];
            }

            //for (int j = 0; j < arr.length; j++) {  这里一定要是倒序才行   因为倒序才是稳定排序
            for (int j = arr.length - 1; j >= 0; j--) {
                int num = arr[j] / division % 10;
                result[--count[num]] = arr[j];     //注意这里和计数排序有些差别
            }

            System.arraycopy(result, 0, arr, 0, arr.length);
            Arrays.fill(count, 0);   //一定要将 count 在初始化为0
        }
    }
}
