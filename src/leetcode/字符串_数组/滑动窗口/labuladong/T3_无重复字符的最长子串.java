package leetcode.字符串_数组.滑动窗口.labuladong;

import java.util.HashSet;

public class T3_无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int vaild = 0;
        int max = 0;
        HashSet<Character> set = new HashSet<>();

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            if (!set.contains(c)) {
                set.add(c);
                if (set.size() > max) {
                    max = set.size();
                }
            } else {
                while (set.contains(c)) {
                    set.remove(s.charAt(left));
                    left++;
                }
                set.add(c);
            }
        }
        return max;
    }
}
