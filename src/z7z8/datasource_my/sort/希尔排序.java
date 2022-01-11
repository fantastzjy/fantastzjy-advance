package z7z8.datasource_my.sort;

/**
 * @create 2020-10-06-13:26
 */
public class 希尔排序 {
    public int[] Sort(int[] num) {
        int len = num.length;
        int h = 1; //排序间隔
        //初始化一个间隔
        while (h < len / 3)
            h = 3 * h + 1;//h = 1 4 13 40 121 364 ....
        while (h >= 1) {
            for (int i = h; i < len; i++) {
                for (int j = i; j >= h && num[j] < num[j - h]; j -= h) {
                    int t = num[j];
                    num[j] = num[j - h];
                    num[j - h] = t;
                }
            }
            h = h / 3; //缩小间隔
        }
        return num;
    }
}