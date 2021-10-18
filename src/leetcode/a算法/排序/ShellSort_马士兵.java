package leetcode.a算法.排序;

/*
希尔排序的组内排序采用的是:

直接插入排序

 */
public class ShellSort_马士兵 {

    public static void shellSort(int[] arr) {
        //    if (arr == null || arr.length < 2) {
        //    return arr;
        //}

        //该算法计算出来的间隔 比二分的间隔效率更高
        int h = 1;

        //如果小于等于1/3就在增大三倍
        while (h <= arr.length / 3) {
            h = 3 * h + 1;
        }

        //最外层控制间距->逐渐改变比较的粒度   中间层向后移动->每个元素都能和前面比较   内层-> 每个元素都向前和自己同间距的比较

        //逐渐减小间隔   和上面gap的生成正好逆向
        for (int gap = h; gap > 0; gap = (gap - 1) / 3) {
            //向后遍历
            for (int i = gap; i < arr.length; i++) {
                //和前面一定间隔的进行比较           随着后移 每次前面相同间隔的会在拍一次序   保证和前面相同间隔的顺序正确
                for (int j = i; j >= gap; j -= gap) {  // 这里不能是 j = i - gap  若是这个就 直接是前面第一个元素和前面第二个元素比较
                    if (arr[j] < arr[j - gap]) {
                        //注意每次比较的是 当前元素 和前面的一个元素  每次相比较的两个元素会比上一次比较的两个元素前移
                        //每一轮元素都不止一次排序   走到后面时，会和前面的相同间隔的再排一次序 避免了 乱序、、、
                        swap(arr, j, j - gap);
                        //如果交换  交换完之后 角标j的值也变成了j-gap   下次比较的还是刚开始的值和前面进行比较
                        //如果不交换          角标j的值也变成了j-gap   下次比较的是 刚才比较的值和他前面的值进行比较
                        //    疑问：  如果相同间隔的前面都已经排好序的话     到后面还会再次把前面相同间隔的值进行遍历比较
                    }
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}