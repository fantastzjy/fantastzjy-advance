package leetcode.a算法.排序;

public class QuickSort_练习 {
    public static void quickSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int p = partial(arr, L, R);
        sort(arr, L, p - 1);
        sort(arr, p + 1, R);
    }

    public static int partial(int[] arr, int l, int r) {
        int v = arr[l];
        int i = l;
        int j = r + 1;

        while (true) {
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
        swap(arr, l, j);
        return j;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
