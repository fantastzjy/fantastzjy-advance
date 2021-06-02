package leetcode.algorithms.sort;

public class InsertSort {

    public static int[] insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }

        //因为是从头循环遍历的 所以i之前的都已经排好序了
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int temp = arr[i];
            int k = i - 1;
            //while循环 用k找到前面比arr[i]大的数
            while (k >= 0 && arr[k] > temp) {
                k--;
            }

            //腾出位置插进去,要插的位置是 k + 1;
            // 因为上一步 如果arr[k] > temp 不大于 此时k对应的值是小于arr[i]的 所以不能交换
            for (int j = i; j > k + 1; j--) {
                //当i>k+1时，  arr[j] = arr[j - 1]; 已经把符合条件的往后移了一位
                //    arr[j - 1] 就是 K+1 那个 符合条件的第一个  k是小于i的
                arr[j] = arr[j - 1];
            }

            //插进去
            arr[k + 1] = temp;
        }

        return arr;
    }
}
