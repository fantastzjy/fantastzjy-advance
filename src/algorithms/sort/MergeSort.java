package algorithms.sort;

public class MergeSort {

    public static void main(String[] args) {

        //在mergeSort_v1 中
        //错误
        //原因是把 1 划入了前面   而划到前面之后 前面的就不是排好序的了，如果没有最后两个while 追加的话结果会是2 3 4 5 6 7 8 1 0
        // int[] arr = {2, 4, 6, 8, 1, 3, 5, 7, 9}; //9
        //正确
        // int[] arr = {1,4,7,8,3,6,9}; //9
        // mergeSort_v1(arr);


        int[] arr = {2, 4, 6, 8, 1, 3, 5, 7, 9}; //9
        mergeSort(arr, 0, arr.length-1);

        for (int i : arr) {
            System.out.print(i + "\t");
        }

    }

    public  static void mergeSort(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        //分成两半
        int mid = left + (right - left) / 2;
        //下面的实现，不断递归划成两半 ，直到最后两个元素排序，在向上一直合并
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid + 1, right);
    }


    public static void merge(int[] arr, int leftPtr, int rightPtr, int rightBound) {

        int mid = rightPtr - 1;
        int[] nums = new int[rightBound - leftPtr + 1]; // 要加 1

        int i = leftPtr;
        int j = rightPtr;
        int k = 0;

        while (i <= mid && j <= rightBound) {
            //里面写< 的话就是不稳定的算法 如果两个值相等顺序会改变
            nums[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }

        while (i <= mid) {
            nums[k++] = arr[i++];  //arr[i];  错误
        }
        while (j <= rightBound) {     //这里不要用j < arr.length
            nums[k++] = arr[j++]; //arr[j];  错误
        }

        //复制到原数组
        for (int l = 0; l < nums.length; l++) {
            arr[l + leftPtr] = nums[l];
        }

    }




    public static void mergeSort_v1(int[] arr) {
        int mid = arr.length / 2;
        int[] nums = new int[arr.length];

        int i = 0;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j < arr.length) {
            nums[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        }

        while (i <= mid) {
            nums[k++] = arr[i++];  //arr[i];  错误
        }
        while (j < arr.length) {
            nums[k++] = arr[j++]; //arr[j];  错误
        }

        print(nums);
    }

    public static void print(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }


}
