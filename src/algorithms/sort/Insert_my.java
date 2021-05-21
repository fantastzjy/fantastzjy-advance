package algorithms.sort;

public class Insert_my {

    public static int[] insertSort(int[] arr) {

        if (arr == null || arr.length < 2) {
            return arr;
        }

        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int k = i - 1;
            while (k >= 0 && arr[k] > temp) {
                k--;
            }

            for (int j = i; j > k + 1; j--) {
                arr[j] = arr[j - 1];
            }

            arr[k + 1] = temp;


        }

        return arr;
    }


}
