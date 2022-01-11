package leetcode.字符串_数组;

//要求：不开辟另外空间！！！！！     时间复杂度 m+n

//思路：倒着填入
//利用 tail指定尾部  让curr存储当前值  一步步向前走
public class T88_合并两个有序数组 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int tail = m + n - 1;
        int cur;

        //注意是  >=0  不是=0   若其中还有角标>-1   则其中一个数组还没走到头
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                cur = nums2[p2--];
            } else if (p2 == -1) {
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }

            nums1[tail--] = cur;
        }
    }
}