package Leetcode.A算法.排序.插入;

//最好情况  已经排好序 O(N)
//最差情况  逆序O(N2)
public class InsertSort_左神 {
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            //后面判断大小是对j位置  判断 不是i  因为每交换一次要向前移动 而i在本轮不变  j向前移动 比较对象向前移动
            //每次交换完后都向前移动
            for (int j = i; j - 1 >= 0 && arr[j - 1] > arr[j]; j--) {
                swap(arr, j, j - 1);//同样也是j-1
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
        //int temp = arr[i];
        //arr[i] = arr[j];
        //arr[j] = temp;
    }
}