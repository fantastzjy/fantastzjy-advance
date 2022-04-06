package Leetcode.A算法.排序.交换;

public class QuickSort_优化 {

    public void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int pivotIndex = getPivotIndex(nums, start, end);
            quickSort(nums, start, pivotIndex - 1);
            quickSort(nums, pivotIndex + 1, end);
        }
    }

    public int getPivotIndex(int[] nums, int start, int end) {
        int pivot = nums[start];
        int low = start;
        int high = end;
        while (low < high) {
            while (low <= high && nums[low] <= pivot)
                low++;
            while (low <= high && nums[high] > pivot)
                high--;
            if (low < high)
                swap(nums, low, high);
        }
        swap(nums, start, high);
        return high;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}