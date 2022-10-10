package leetcode.A算法.排序.交换;

/*
冒泡排序属于交换排序，是一种稳定的排序，平均/最坏时间复杂度均为 O(n²)，
当元素基本有序时最好时间复杂度为O(n)，空间复杂度为 O(1)。
 */


//**优化：**当序列已经有序时仍会进行不必要的比较，可以设置一个标志记录是否有元素交换，如果没有直接结束比较。
// （zjy因为每轮循环走回走一遍比较相邻的值  如果没有交换 就是 已经有序的了）

public class BubbleSort {
    public static int[] bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }

        int n = arr.length;
        boolean swap;
        //一共多少个元素就循环多少轮  每一轮循环后最大的到最右边
        for (int i = 0; i < n; i++) {
            swap = true;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                    swap = false;
                }
            }
            if (swap) break;
        }
        return arr;
    }
}