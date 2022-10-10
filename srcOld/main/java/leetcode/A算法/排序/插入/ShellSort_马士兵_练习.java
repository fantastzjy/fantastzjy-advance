package leetcode.A算法.排序.插入;


public class ShellSort_马士兵_练习 {

    public static void shellSort(int[] arr) {
        int h = 1;
        if (h <= arr.length / 3) {
            h = 3 * h + 1;
        }
        for (int gap = h; gap > 0; gap = (gap - 1) / 3) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i; j >= gap; j -= gap) {
                    if (arr[j] < arr[j - gap]) {
                        swap(arr, j, j - gap);
                    }
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}