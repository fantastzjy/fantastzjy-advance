package 笔试;

import java.util.Scanner;

public class jd1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        int maxIndex = 0;
        int minIndex = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        //都在左边
        for (int i = 0; i < n; i++) {
            minIndex = arr[i] <= arr[minIndex] ? i : minIndex;
            maxIndex = arr[i] >= arr[maxIndex] ? i : maxIndex;
        }
        int r1 = maxIndex > minIndex ? maxIndex + 1 : minIndex + 1;

        //大左小右
        maxIndex = 0;
        minIndex = 0;
        for (int i = 0; i < n; i++) {
            minIndex = arr[i] <= arr[minIndex] ? i : minIndex;
            maxIndex = arr[i] > arr[maxIndex] ? i : maxIndex;
        }
        int r2 = maxIndex + 1 + n - minIndex;

        //大右小左
        maxIndex = 0;
        minIndex = 0;
        for (int i = 0; i < n; i++) {
            minIndex = arr[i] < arr[minIndex] ? i : minIndex;
            maxIndex = arr[i] >= arr[maxIndex] ? i : maxIndex;
        }
        int r3 = n - maxIndex + minIndex + 1;

        //都在右
        maxIndex = 0;
        minIndex = 0;
        for (int i = 0; i < n; i++) {
            minIndex = arr[i] <= arr[minIndex] ? i : minIndex;
            maxIndex = arr[i] >= arr[maxIndex] ? i : maxIndex;
        }
        int r4 = maxIndex < minIndex ? n - maxIndex : n - minIndex;


        System.out.println(Math.min(r1, Math.min(r2, Math.min(r3, r4))));

    }
}
