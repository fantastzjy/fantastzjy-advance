package algorithms.sort;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class TimeTest {
    public static void main(String[] args) {

        int[] arr = new int[80000000]; //8qianwan
        //int[] arr = new int[8];
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
        //InsertSort.insertSort(arr);
        QuickSort.quickSort(arr);  //2s
        //ShellSort.shellSort(arr);   //时间没测出来  为什么尚硅谷版本的那么快？？？
        //ShellSort_尚硅谷.shellSort(arr); //2-3s
        //MergeSort.mergeSort(arr,0, arr.length-1); //2s
        //计数排序
        //CountSort.countSort(arr);
        //基数排序
        //BaseSort.baseSort(arr, findLen(arr));  //1s



        //System.out.println(Arrays.toString(arr));

        System.out.println();


        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后=" + date2Str);


    }

}
