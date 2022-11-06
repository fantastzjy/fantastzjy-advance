package fantastzjy.leetcode.字符串_数组.滑动窗口;

import java.util.HashMap;

public class T3_无重复字符的最长子串_优化_my {

    //与优化版本不同  优化版本更简洁
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); ) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
            } else {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
                //这里其实还有漏洞 但是补上了  i没有++ 在下一轮循环有将这里删除的key添加进来
                // 还是优化版本好直接利用放进去就更新的特性
                map.remove(s.charAt(i));
                continue;
            }
            max = Math.max(max, i - left + 1);
            i++;
        }
        return max;
    }
}