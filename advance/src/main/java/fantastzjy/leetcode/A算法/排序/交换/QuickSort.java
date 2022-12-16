package fantastzjy.leetcode.A算法.排序.交换;

public class QuickSort {
    public static void quickSort(int[] arr) {
        //这里和下面的方法合并不了
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int l, int r) {
        //控制是否进行排序   若是只有两个元素  返回的j对应的是左边界的  下面会进行第二个sort排序   第一个sort直接越界
        // 若是只有一个元素也不用排序
        if (l >= r) {
            return;
        }
        //注意这里和下面的左边都不能写0
        int j = partition(arr, l, r);
        sort(arr, l, j - 1);
        sort(arr, j + 1, r);
    }

    //左边找右边找不等边界不交叉
    public static int partition(int[] arr, int l, int r) {
        int v = arr[l];
        //最左边参不参与下面的两个while循环不影响，因为和自身相比较
        int i = l;
        int j = r + 1;

        //这个while是让左右两边每交换一次就继续下一轮的查找交换
        while (true) {
            //注意这里是while循环
            while (arr[++i] < v && i != r) {
                //一重保险  左右指针越过另一边边界
                //if (i == r) {
                //    break;
                //}
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
        //！！！！！！！！！！！
        //假如剩下的最后两个   是因为i>=j    则j对应的是左边的  i对应的是右边的
        // 若是与i对应的交换  就会出现 比如 p =5  j=3 i=6  交换完变成 635   错误
        // 若是与j对应的交换  就会出现 比如 p =5  j=3 i=6  交换完变成 356  正序
        //若是剩下最后两个元素    比如 p =5  j=5 i=6     只有与j对应的交换才正确
        swap(arr, l, j);
        return j;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
