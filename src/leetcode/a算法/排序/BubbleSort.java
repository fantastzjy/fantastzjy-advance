package leetcode.a算法.排序;

//优化方法！！！！！
//当排序伏安法分别执行到第六、第七、第八轮的时候，数列的状态其实已经变为有序的了。
//设置一个flags，如果已经排序了那么设置为0；如果不是有序的，那么设置为1。

public class BubbleSort {
    public static int[] bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }

        int n = arr.length;
        //一共多少个元素就循环多少轮  每一轮循环后最大的到最右边
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
        return arr;
    }
}