package Leetcode.字符串_数组.滑动窗口.labuladong;

import java.util.HashMap;

public class T567_字符串的排列 {
    public static void main(String[] args) {
        System.out.println(T567_字符串的排列.checkInclusion("ooolleoooleh", "hello"));

    }


    public static boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> win = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (need.containsKey(c)) {
                need.put(c, need.get(c) + 1);
            } else {
                need.put(c, 1);
            }
        }

        int vaild = 0;
        int left = 0, right = 0;
        int len1 = s1.length();
        while (right < len1) {
            char c = s1.charAt(right);
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
                if (right - left == s2.length()) {
                    return true;
                }

                char ss = s1.charAt(left);
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


        return false;
    }
}