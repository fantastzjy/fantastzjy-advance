package leetcode.dp;

import java.util.HashSet;

public class T128_2 {
    public int longestConsecutive(int[] nums) {
        int longestStreak = 0;

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {   //用set快
            if (!set.contains(num - 1)) {
                int curr = num;
                int currlen = 1;
                while (set.contains(curr + 1)) {
                    curr++;
                    currlen++;
                }
                longestStreak = Math.max(longestStreak, currlen);
            }
        }
        return longestStreak;
    }
}
