package leetcode.a算法.排序;

//最好情况  已经排好序 O(N)
//最差情况  逆序O(N2)
public class InsertSort_左神_练习 {
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j - 1 >= 0 && arr[j] < arr[j - 1]; j--) {
                swap(arr, j, j - 1);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        //arr[i] = arr[i] ^ arr[j];
        //arr[j] = arr[i] ^ arr[j];
        //arr[i] = arr[i] ^ arr[j];
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}