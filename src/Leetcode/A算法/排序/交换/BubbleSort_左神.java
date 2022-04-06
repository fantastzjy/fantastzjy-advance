package Leetcode.A算法.排序.交换;

public class BubbleSort_左神 {
    public static int[] bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }

        int n = arr.length;
        //左神这里用的 倒序  写边界更方便
        for (int end = n - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                if (arr[i + 1] < arr[i]) {
                    int t = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = t;
                }
            }
        }
        return arr;
    }
}