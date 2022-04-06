package Leetcode.字符串_数组.滑动窗口;

import java.util.HashMap;

public class T3_无重复字符的最长子串_优化_my_ {

    //思路 不删除，只更新左边界、和map中存储的元素

    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        int len = s.length();
        int i = 0;
        int max = 0;
        int left = 0;
        while (i < len) {

            //若包含 则先进行判断是否是left右边的有效值（在窗口范围内）   是有效值则更新左边界
            if (map.containsKey(s.charAt(i))) {

                Integer index = map.get(s.charAt(i));
                //等于时说明最左边包含！！！！！！！！！！！！！
                if (index >= left) {
                    left = index + 1;
                }
            }

            map.put(s.charAt(i), i);

            max = max > i - left + 1 ? max : i - left + 1;
            i++;
        }

        return max;
    }
}