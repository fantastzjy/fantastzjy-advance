package leetcode.二分_labuladong.搜索旋转二分;

import java.util.Scanner;

public class 寻找旋转排序数组最大值 {
    public int findMax(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        if (nums[l] <= nums[r]) {
            return nums[r];
        }
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[l] == nums[mid]) {
                return nums[mid];
            }

            if (nums[l] < nums[mid]) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        str = str.trim();
        String[] split = str.split("\\s+");

        int[] arrs = new int[split.length];
        for (int j = 0; j < split.length; j++) {
            arrs[j] = Integer.parseInt(split[j]);
        }
        System.out.println(new 寻找旋转排序数组最大值().findMax(arrs));
    }
}