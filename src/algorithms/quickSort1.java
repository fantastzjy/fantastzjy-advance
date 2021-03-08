package algorithms;

import java.text.BreakIterator;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class quickSort1 {

    public static void main(String[] args) {
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前=" + date1Str);

        new HashMap<>(16);
        quickSort1 quickSort = new quickSort1();
        int[] arr = new int[80000000];
        for (int i = 0; i < 80000000; i++) {
            arr[i] = (int) (Math.random() * 80000000);
        }
        quickSort.quickSort(arr);


        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后=" + date2Str);


    }


    public int[] quickSort(int[] arr) {
        sort(arr, 0, arr.length-1);
        return arr;
    }

    public  void sort(int[] arr, int l, int r) {
        if(l>=r){
            return ;
        }
        int j = partition(arr, l, r);
        sort(arr, l, j - 1);
        sort(arr, j + 1, r);

    }

    public int partition(int[] arr, int l, int r) {
        int v = arr[l];
        int i = l;
        int j = r + 1;
        while(true){
            while(arr[++i]<v){
                if(i==r){
                    break;
                }
            }
            while(arr[--j]>v){
                if(j==l){
                    break;
                }
            }
            if(i>=j){
                break;
            }

            exch(arr,i,j);


        }

        exch(arr, l, j);

        return j;
    }

    private void exch(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
