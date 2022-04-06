package Leetcode.A算法.排序.归并;

public class MergeSort {

    public static void main(String[] args) {

        //在mergeSort_v1 中
        //错误
        //原因是把 1 划入了前面   而划到前面之后 前面的就不是排好序的了，如果没有最后两个while 追加的话结果会是2 3 4 5 6 7 8 1 0
        // int[] arr = {2, 4, 6, 8, 1, 3, 5, 7, 9}; //9
        //正确
        // int[] arr = {1,4,7,8,3,6,9}; //9
        // mergeSort_v1(arr);

        int[] arr = {2, 4, 6, 8, 1, 3, 5, 7, 9}; //9
        mergeSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }


    //时间复杂度 NlogN        分成两半  logn    有多少次分成两半？  有n-1个区间，所以分n-1次  所以 nlogn
    //空间复杂度 就是创建临时数组  创建的那些临时数组长度合起来仍然是和原数组长度一样O（N）
    //左、右、合并
    public static void mergeSort(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        //分成两半
        int mid = left + (right - left) / 2;
        //下面的实现，不断递归划成两半 ，直到最后两个元素排序，在向上一直合并
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        //特殊情况 如果只剩下两个元素  上面两个mergesort都是直接return    最后会在下面merge中会进行排序！！！！！！！！
        merge(arr, left, mid, right);

    }


    public static void merge(int[] arr, int L, int mid, int R) {
        int[] temps = new int[R - L + 1]; // 要加 1
        // 区间长度
        int k = 0;
        int p1 = L;
        int p2 = mid + 1;

        while (p1 <= mid && p2 <= R) {
            //如果不是等于的话 一个到头了一个没到头  比如第一个没到头 第二个到头了  下面两个while循环会导致第二个的值放到了最后  不是有序的了
            temps[k++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        //这里大坑！！！！  注意是while！！！！
        while (p1 <= mid) {
            temps[k++] = arr[p1++];  //arr[p1];  错误
        }
        while (p2 <= R) {     //这里不要用j < arr.length
            temps[k++] = arr[p2++]; //arr[p2];  错误
        }

        //复制到原数组
        //for (int i = 0; i < temps.length; i++) {
        //    arr[L + i] = temps[i];
        //}

        //array were copied into positions destPos through destPos+length-1 of the destination array.
        //   最后一个参数是长度
        System.arraycopy(temps, 0, arr, L, temps.length);
    }

}
