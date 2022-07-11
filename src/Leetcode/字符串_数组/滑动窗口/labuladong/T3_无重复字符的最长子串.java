package Leetcode.字符串_数组.滑动窗口.labuladong;

import java.util.HashSet;

public class T3_无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int vaild = 0;
        int max = 0;
        HashSet<Character> set = new HashSet<>();

        //不包含就添加，
        //包含就一只删除左边的，知道将重复的删除掉
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
                //!删完之后再将当前与元素加上    这里不用处理长度了  因为删除了就不是最长了
                set.add(c);
            }
        }
        return max;
    }
}
