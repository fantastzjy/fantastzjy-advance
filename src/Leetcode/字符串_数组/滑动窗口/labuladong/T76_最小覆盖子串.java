package Leetcode.字符串_数组.滑动窗口.labuladong;

import java.util.HashMap;
/*
未通过的几种情况
   若 min=len
   输入： a b   会导致 没有进入内层while  而 min的值没有改变
         a a     min==len的值
         a aa    不成立 min进不去while  导致min没初始化
         解决办法
         min改为len+1  或者 integer.maxvalue
         且增加  if (min == len+1) {            return "";        }

        错误原因没考虑特殊情况
 */

public class T76_最小覆盖子串 {

    public static void main(String[] args) {
        System.out.println(T76_最小覆盖子串.minWindow("a",
                "b"));
    }


    public static String minWindow(String s, String t) {
        int len = s.length();

        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (need.containsKey(c)) {
                need.put(c, need.get(c) + 1);
            } else {
                need.put(c, 1);
            }
        }

        int left = 0;
        int right = 0;
        int vaild = 0;
        int min = len + 1;
        int start = 0;

        while (right < len) {

            char c = s.charAt(right);
            right++;

            if (need.containsKey(c)) {
                if (window.containsKey(c)) {
                    window.put(c, window.get(c) + 1);
                } else {
                    window.put(c, 1);
                }

                if (window.get(c).equals(need.get(c))) {
                    vaild++;
                }
            }

            while (vaild == need.size()) {
                if (right - left < min) {
                    start = left;
                    min = right - left;
                }

                char ss = s.charAt(left);
                left++;

                //if (window.containsKey(ss)) {
                //    if (window.get(ss) == 1) {
                //        window.remove(ss);
                //    } else {
                //        window.put(ss, window.get(ss) - 1);
                //    }
                //    vaild--;
                //}
                if (need.containsKey(ss)) {
                    /*
                      t中的某个元素数量可能不止一个  s中window(x)的数量在勤勉加的时候可能大于t中的
                      **但是大于的时候 其vaild仍然有效**  只有当小于的时候 某个元素的数量在 window 小于 need vaild 才失效
                     */
                    if (window.get(ss).equals(need.get(ss))) {
                        vaild--;
                    }

                    //这里要从集合中移除掉才行
                    if (window.get(ss) == 1) {
                        window.remove(ss);
                    } else {
                        window.put(ss, window.get(ss) - 1);
                    }
                }
            }
        }

        if (min == len + 1) {
            return "";
        }
        return s.substring(start, start + min);
    }
}