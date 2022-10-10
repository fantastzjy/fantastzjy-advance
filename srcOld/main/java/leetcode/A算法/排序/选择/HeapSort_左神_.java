package leetcode.A算法.排序.选择;

/**
 * 堆排序
 * heapInsert 是在末尾插入  向上比较    heapify是头部值和末尾交换值  向下比较
 */
public class HeapSort_左神_ {
    public static void main(String[] args) {
        System.out.println(-1 / 2);

        int largest = 0 + 1 < 1 && 0 > 1 ? 0 : 1;
        //largest = 0 + 1 < 1 && 1 > 0 ? 1 : 0;

        System.out.println(largest);

    }

    public static void heapSort(int[] arr) {

        //base
        if (arr == null || arr.length < 2) {
            return;
        }

        //heapInsert

        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }

        int size = arr.length;

        swap(arr, 0, --size);

        while (size > 0) {
            //heapify
            heapify(arr, 0, size);
            swap(arr, 0, --size);
        }

    }


    private static void heapInsert(int[] arr, int i) {
        while (arr[i] > arr[(i - 1) / 2]) {
            swap(arr, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    private static void heapify(int[] arr, int index, int size) {

        //找出最大值
        int left = index * 2 + 1;

        while (left < size) {

            //  注意这里  只要其中一个条件为false   就是后面的结果 left   使用下面第二行才正确
            //int largest = left + 1 < size && arr[left] > arr[left + 1] ? left : left + 1;
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;


            //判断是否为本身
            if (arr[largest] < arr[index]) {
                break;
            }


            //交换\改变索引

            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}