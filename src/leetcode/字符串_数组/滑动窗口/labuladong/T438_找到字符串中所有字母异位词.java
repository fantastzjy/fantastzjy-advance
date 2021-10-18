package leetcode.字符串_数组.滑动窗口.labuladong;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class T438_找到字符串中所有字母异位词 {
    public static void main(String[] args) {
        System.out.println(T438_找到字符串中所有字母异位词.findAnagrams("cbaebabacd", "abc"));

    }

    public static List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> win = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (need.containsKey(c)) {
                need.put(c, need.get(c) + 1);
            } else {
                need.put(c, 1);
            }
        }

        int vaild = 0;
        int left = 0, right = 0;
        int len1 = s.length();
        while (right < len1) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                if (win.containsKey(c)) {
                    win.put(c, win.get(c) + 1);
                } else {
                    win.put(c, 1);
                }
                if (need.get(c).equals(win.get(c))) {
                    vaild++;
                }
            }

            while (vaild == need.size()) {
                if (right - left == p.length()) {
                    list.add(left);
                }

                char ss = s.charAt(left);
                left++;
                if (win.containsKey(ss)) {
                    if (need.get(ss).equals(win.get(ss))) {
                        vaild--;
                    }

                    if (win.get(ss) == 1) {
                        win.remove(ss);
                    } else {
                        win.put(ss, win.get(ss) - 1);
                    }
                }

            }

        }


        return list;
    }
}