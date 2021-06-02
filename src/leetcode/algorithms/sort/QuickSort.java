package leetcode.algorithms.sort;

public class QuickSort {


    public static void quickSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
        //这里和下面的方法合并不了
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
        while (true) {
            //注意这里是while循环
            while (arr[++i] < v) {
                if (i == r) {
                    break;
                }
            }
            while (arr[--j] > v) {
                if (j == l) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }

            swap(arr, i, j);

        }
        //加入只剩下最后两个不管是3
        swap(arr, l, j);
        //System.out.println("1111111111111");
        return j;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
