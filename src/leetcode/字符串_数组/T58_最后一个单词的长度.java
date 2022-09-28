package leetcode.字符串_数组;

public class T58_最后一个单词的长度 {

    public int lengthOfLastWord(String s) {
        s = s.trim();
        int i = s.lastIndexOf(" ");
        StringBuilder stringBuilder = new StringBuilder("");
        for (int j = i+1; j < s.length(); j++) {
            stringBuilder.append(s.charAt(j));
        }
        return stringBuilder.toString().length();
    }



}
