package Leetcode.A算法.排序;

import Leetcode.A算法.排序.选择.HeapSort_左神_;

import java.util.Arrays;

//左程云对数器
public class TestRight {
    //主方法中：
    public static void main(String[] args) {
        //testTime是测试次数
        int testTime = 500000;
        int size = 10;
        int value = 100;
        boolean succeed = true;

        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(size, value);
            //拷贝数组，数组new出来的就是在栈中不同的空间中存放，内容相同
            //copyArray(int[] arr)是自己实现的拷贝方法
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);

            //需要验证的方法
            //ShellSort_马士兵_练习.shellSort(arr1);
            //CountSort.countSort(arr1);
            //QuickSort.quickSort(arr1);
            HeapSort_左神_.heapSort(arr1);

            rightMethod(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                //打印出错的数组，printArray是自习实现的打印的方法
                printArray(arr3);
                break;
            }
        }
        //打印要测的部分是否正确
        System.out.println(succeed ? "succeed!" : "false..");
    }

    // for test 一个绝对正确的方法，调用java自带的排序方法
    public static void rightMethod(int[] arr) {
        Arrays.sort(arr);
    }

    // for test 随机数组生成器
    /*
     * Math.random() -> double[0,1)
     * (int) ((size + 1) * Math.random()) -> [0, size]
     * size = 6, size + 1 = 7
     * Math.random() -> [0,1) * 7 -> [0,7)double
     * double -> int[0,6] -> int
     */
    public static int[] generateRandomArray(int size, int value) {
        //产生的数组长度是[0, size]
        int[] arr = new int[(int) ((size + 1) * Math.random())];

        //产生的数组中的数的范围是-value ~ value
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((value + 1) * Math.random()
                    - (int) (value * Math.random()));
        }
        return arr;
    }

    //拷贝数组
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    //判断两个数组是否相等
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {

            return false;
        }
        if (arr1 == null && arr2 == null) {

            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    //5、如果有一个样本使得比对出错，打印样本分析是哪个方法出错
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
