package fantastzjy.leetcode.字符串_数组;

import java.util.ArrayDeque;
import java.util.Deque;

//我写的
public class T151_翻转字符串里的单词_ {
    public static void main(String[] args) {
        System.out.println(String.join("-", "sdfsd", "fsdfsdf", "fsdfdsfsd"));
    }

    public String reverseWords(String s) {
        int left = 0, right = s.length() - 1;
        String[] str = s.trim().split("\\s+");

        Deque<String> d = new ArrayDeque<String>();
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            d.offerFirst(str[i]);
        }

        while (!d.isEmpty()) {
            word.append(d.pollFirst());
            if (!d.isEmpty()) {
                word.append(" ");
            }
        }

        //return String.join(" ", d);
        return word.toString();
    }
}