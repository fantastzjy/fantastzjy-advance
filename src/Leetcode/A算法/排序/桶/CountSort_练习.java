package Leetcode.A算法.排序.桶;

import java.util.Arrays;

public class CountSort_练习 {
    public static void main(String[] args) {
        int[] arr = {2, 4, 2, 3, 7, 6, 5, 4, 4, 5, 6, 8, 9, 0, 0, 9, 1, 2, 6, 5, 4, 3};
        CountSort_练习.countSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void countSort(int[] arr) {

        int[] count = new int[10];
        int[] res = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            res[--count[arr[i]]] = arr[i];
        }

        System.arraycopy(res, 0, arr, 0, res.length);

    }

}