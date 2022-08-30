package leetcode.字符串_数组.滑动窗口.labuladong;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class T438_找到字符串中所有字母异位词_ {
    public static void main(String[] args) {
        System.out.println(T438_找到字符串中所有字母异位词_.findAnagrams("cbaebabacd", "abc"));

    }

    public static List<Integer> findAnagrams(String s, String p) {

        HashMap<Character, Integer> win = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        //初始化need
        for (int i = 0; i < p.length(); i++) {
            if (need.containsKey(p.charAt(i))) {
                need.put(p.charAt(i), need.get(p.charAt(i)) + 1);
            } else {
                need.put(p.charAt(i), 1);
            }
        }


        int vaild = 0;
        int left = 0;
        int right = 0;
        int len = s.length();

        while (right < len) {

            //加入字符
            char ch = s.charAt(right);
            right++;
            //win中只加入need中含有的即可
            //if (win.containsKey(ch)) {
            //    win.put(ch, win.get(ch) + 1);
            //} else {
            //    win.put(ch, 1);
            //}
            //
            //if (need.containsKey(ch)) {
            //
            //    if (need.get(ch).equals(win.get(ch))) {
            //        vaild++;
            //    }
            //}
            if (need.containsKey(ch)) {

                if (win.containsKey(ch)) {
                    win.put(ch, win.get(ch) + 1);
                } else {
                    win.put(ch, 1);
                }

                if (need.get(ch).equals(win.get(ch))) {
                    vaild++;
                }
            }

            //判断添加之后是否满足条件
            while (vaild == need.size()) {

                //处理vaild
                if (right - left + 1 == p.length()) {
                    list.add(left);
                }

                //注意left++的顺序
                char ss = s.charAt(left);
                left++;

                if (need.containsKey(ss)) {

                    if (win.get(ss).equals(need.get(ss))) {
                        vaild--;
                    }

                    //删除win中
                    Integer num = win.get(ss);
                    if (num > 1) {
                        win.put(ss, num - 1);
                    } else {
                        win.remove(ss);
                    }
                }
            }


        }


        return list;
    }
}