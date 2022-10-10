package leetcode.字符串_数组.滑动窗口;

import java.util.HashSet;

//滑动窗口
//时间复杂度 O(N)  左右指针分别遍历一遍字符串

//和使用hashmap相比比较麻烦  因为不知道 重复的元素的位置在那里 只能通过循环从左边一直删除

public class T3_无重复字符的最长子串_官方_改进笔记 {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        HashSet<Character> set = new HashSet<>();
        //不能初始化为1  前面省了空字符串的检验这里初始化为1   若是空串 应该为0
        int max = 0;
        int r = 0;
        for (int i = 0; i < len; i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1)); //////这里应该是 i-1  当有重复的时候是从i-1位置上开始有重复的  i加过了
            }
            //只要有重复的就会一直进不去while循环  r也不会++  直到前面不包含重复元素   不然每次for循环会删掉第一个
            while (r < len && !set.contains(s.charAt(r))) {
                set.add(s.charAt(r));
                r++;
            }

            //由于有重复的时候r位置包含重复元素 长度减一   r-1 - i +1  》》r-i
            max = Math.max(max, r - i);
        }
        return max;
    }
}
