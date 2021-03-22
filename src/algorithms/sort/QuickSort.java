package algorithms.sort;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

public class QuickSort {

    public static void main(String[] args) {
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前=" + date1Str);

        new HashMap<>(16);
        QuickSort quickSort = new QuickSort();
        int[] arr = new int[8000000];
        //如果arr.length  直接写成   8000000是编码规约不允许的 这个叫魔法值
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (new Random().nextInt());
        }
        quickSort.sort(arr);
        //for (int i = 0; i < arr.length; i++) {
        //    System.out.println(arr[i]);
        //}

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后=" + date2Str);


    }

    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
        //这里和下面的方法合并不了
    }

    public void sort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        //注意这里和下面的左边都不能写0
        int j = partition(arr, l, r);
        sort(arr, l, j - 1);
        sort(arr, j + 1, r);

    }


    public int partition(int[] arr, int l, int r) {
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

            exch(arr, i, j);

        }
        //加入只剩下最后两个不管是3
        exch(arr, l, j);
        //System.out.println("1111111111111");
        return j;
    }

    public void exch(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
