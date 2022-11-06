package fantastzjy.leetcode.A算法.排序.桶;

import java.util.Arrays;

public class CountSort {
    public static void main(String[] args) {
        int[] arr = {2, 4, 2, 3, 7, 6, 5, 4, 4, 5, 6, 8, 9, 0, 0, 9, 1, 2, 6, 5, 4, 3};
        CountSort.countSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void countSort(int[] arr) {

        int[] count = new int[arr.length];
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i - 1];
        }
        //--count 是因为 个数的统计是从1开始的  但是数组是从0开始的
        // count的长度指定为arr.length 这里并不影响,因为count记录的是  复制arr[i]给result[--count[arr[i]] 处
        //所以count中间有空值也并不影响
        //在 count[i] = count[i] + count[i - 1]; 也没事  因为如果个数是0的话并不影响值还可以为后面记录位置把该到哪传过去

        //现在是不稳定的  把i倒叙  才是稳定排序
        //for (int i = 0; i < arr.length; i++) {   //不稳定！！！
        for (int i = arr.length - 1; i >= 0; i--) {//这样倒序向前方才是稳定的
            result[--count[arr[i]]] = arr[i];
        }
        //result做一个临时结果的暂存  每一轮循环完要从新赋值给arr
        System.arraycopy(result, 0, arr, 0, arr.length);
    }
}