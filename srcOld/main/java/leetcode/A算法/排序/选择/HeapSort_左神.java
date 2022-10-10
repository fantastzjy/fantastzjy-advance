package leetcode.A算法.排序.选择;

/**
 * 堆排序
 * heapInsert 是在末尾插入  向上比较    heapify是头部值和末尾交换值  向下比较
 */
public class HeapSort_左神 {
    public static void main(String[] args) {
        System.out.println(-1 / 2);
    }

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //nlogn
        for (int i = 0; i < arr.length; i++) {//O(N)次
            heapInsert(arr, i);//0~i调成大根堆 O(logN)
        }
        int size = arr.length;//堆的有效size
        //从小到大排序
        //上面插入完之后已经是一个有序堆了  可以直接进行交换
        swap(arr, 0, --size);//最大值，和堆中最后一个数交换，堆有效size-1
        //nlogn
        while (size > 0) {//O(N)次
            //树化    从0 开始  长度为size  size不是数组最后一个位置!!!    heapif中 size也是指 元素个数
            //heapify中 size指的是 有效长度.length
            heapify(arr, 0, size);//O(logN)   当size=1时  下面是和本身进行交换
            swap(arr, 0, --size);
        }
    }


    //前提：arr[0...index-1]已经是大根堆了，arr[index]位置是新加的数
    //arr[0...index]调成大根堆
    public static void heapInsert(int[] arr, int index) {
        //当i=0时  (i-1)/2  -> -1/2=0 计算出来的仍然是0位置的数   while循环里的就是和自己比   达到管理边界的效果
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    //arr[i]位置的值发生了变化，并且是变小，堆大小是size(arr[0~size-1])，请重新调整成大根堆
    public static void heapify(int[] arr, int index, int size) {
        int left = index * 2 + 1;//左孩子的位置
        //如果当前位置的数有孩子的话，循环发生    如果没有的话 就是叶子结点了
        while (left < size) {
            //两个孩子最大值的坐标
            //如果右孩子有的话，和左孩子的值比较，最大的值的下标，作为largest的值
            int largest = left + 1 < size //右孩子如果不越界
                    && arr[left + 1] > arr[left]//右孩子的值大于左孩子的值
                    ? left + 1 : left;
            //最大的孩子和父结点的值比较，最大的值的下标，作为largest的值
            largest = arr[largest] > arr[index] ? largest : index;
            //如果最大的值的下标已经是父结点的位置，过程停止
            if (largest == index) {
                break;
            }
            //选出来的largest的 位置一定不是i位置，是i位置的左右两个孩子中，较大数的下标
            swap(arr, largest, index);  //largest!=index
            index = largest;   //继续向下判断  顺便计算做孩子下标  因为通过下标判断是否越界  且才开始进入该循环时left已经计算出来了
            left = index * 2 + 1;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}