package leetcode.a算法.排序;

public class MergeSort_练习 {

    public static void main(String[] args) {
        //int[] arr = {2, 4, 6, 8, 1, 3, 5, 7, 9}; //9
        int[] arr = {2, 5, 3, 1, 4}; //9
        mergeSort(arr, 0, arr.length - 1);
        //for (int i : arr) {
        //    System.out.print(i + " ");
        //}
    }

    //左、右、合并
    public static void mergeSort(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
        print(arr);
    }

    private static void merge(int[] arr, int L, int mid, int R) {
        int[] temps = new int[R - L + 1];
        int k = 0;
        int p1 = L;
        int p2 = mid + 1;

        while (p1 <= mid && p2 <= R) {
            temps[k++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        //这里大坑！！！！  注意是while！！！！
        while (p1 <= mid) {
            temps[k++] = arr[p1++];
        }
        while (p2 <= R) {
            temps[k++] = arr[p2++];
        }

        for (int j = 0; j < temps.length; j++) {
            arr[L + j] = temps[j];
        }
        //print(arr);
    }

    public static void print(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
