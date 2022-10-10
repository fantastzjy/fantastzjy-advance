package fantastzjy.leetcode.字符串_数组;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class T349_两个数组的交集 {

    //方法一：两个集合求交集
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }
        return getIntersection(set1, set2);

    }

    private int[] getIntersection(Set<Integer> set1, Set<Integer> set2) {
        if (set1.size() > set2.size()) {
            return getIntersection(set2, set1);
        }
        Set<Integer> intersectionSet = new HashSet<Integer>();
        //这里把循环时 integer类型换成int类型会更快
        //for (Integer integer : set1) {
        //    if (set2.contains(integer)) {
        //        intersectionSet.add(integer);
        //    }
        //}
        //这里把循环时 integer类型换成int类型会更快
        for (int num : set1) {
            if (set2.contains(num)) {
                intersectionSet.add(num);
            }
        }

        int[] ints = new int[intersectionSet.size()];
        int index = 0;
        for (Integer integer : intersectionSet) {
            ints[index++] = integer;
        }
        return ints;
    }


    //方法二：排序 + 双指针
    public int[] intersection2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length, length2 = nums2.length;
        int[] intersection = new int[length1 + length2];
        int index = 0, index1 = 0, index2 = 0;
        //拍完顺序之后，一个数组走到头就结束了，即使另一个数组没有走完也说明没有相同的了，因为拍过序了
        while (index1 < length1 && index2 < length2) {
            int num1 = nums1[index1], num2 = nums2[index2];
            if (num1 == num2) {
                // 保证加入元素的唯一性   ，如果唯一就加入，如果不唯一，角标就都加1，  这点容易忘记
                if (index == 0 || num1 != intersection[index - 1]) {
                    intersection[index++] = num1;
                }
                index1++;
                index2++;
            } else if (num1 < num2) {
                index1++;
            } else {
                index2++;
            }
        }

        return Arrays.copyOfRange(intersection, 0, index);

    }

}
