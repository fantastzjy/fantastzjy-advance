package leetcode.a算法.排序;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class TestTime {
    public static void main(String[] args) {

        //int[] arr = new int[80000000]; //8qianwan
        int[] arr = new int[8];
        //如果arr.length  直接写成   8000000是编码规约不允许的 这个叫魔法值
        for (int i = 0; i < arr.length; i++) {
            //arr[i] = (new Random().nextInt());   如果不指定范围就会包含负数
            arr[i] = (new Random().nextInt(10000000));
            //arr[i] = Math.random() * 128;;
        }

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前=" + date1Str);

        //SelectSort.selectSort(arr);
        //InsertSort_复杂.insertSort(arr);
        //InsertSort_左神_练习.insertionSort(arr);

        //快速
        //QuickSort.quickSort(arr);  //2s
        //QuickSort_练习.quickSort(arr);  //2s

        //希尔
        //ShellSort.shellSort(arr);   //时间没测出来  为什么尚硅谷版本的那么快？？？
        //ShellSort_尚硅谷.shellSort(arr); //2-3s
        ShellSort_马士兵_练习.shellSort(arr);
        //归并
        //MergeSort.mergeSort(arr,0, arr.length-1); //2s

        //计数排序
        //CountSort.countSort(arr);

        //基数排序
        //BaseSort.baseSort(arr, findLen(arr));  //1s

        //堆排序
        //int[] num = {1, 2, 1, 6, 2};
        //HeapSort.heapSort(arr);  //32
        //HeapSort_左神_练习.heapSort(arr);
        //System.out.println(Arrays.toString(num));


        System.out.println(Arrays.toString(arr));

        System.out.println();

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后=" + date2Str);
    }
}
