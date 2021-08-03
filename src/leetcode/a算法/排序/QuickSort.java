package leetcode.a算法.排序;

public class QuickSort {


    public static void quickSort(int[] arr) {
        //这里和下面的方法合并不了
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        //注意这里和下面的左边都不能写0
        int j = partition(arr, l, r);
        sort(arr, l, j - 1);
        sort(arr, j + 1, r);
    }


    public static int partition(int[] arr, int l, int r) {
        int v = arr[l];
        int i = l;
        int j = r + 1;

        //这个while是让左右两边每交换一次就继续下一轮的查找交换
        while (true) {
            //注意这里是while循环
            while (arr[++i] < v) {
                //一重保险  左右指针越过另一边边界
                if (i == r) {
                    break;
                }
            }
            while (arr[--j] > v) {
                //一重保险  左右指针越过另一边边界
                if (j == l) {
                    break;
                }
            }

            //二重保险  左右指针交叉
            if (i >= j) {
                break;
            }

            swap(arr, i, j);

        }
        //加入只剩下最后两个不管是
        swap(arr, l, j);

        return j;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
