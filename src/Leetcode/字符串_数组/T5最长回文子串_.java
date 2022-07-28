package Leetcode.字符串_数组;


public class T5最长回文子串_ {

    public static void main(String[] args) {
        System.out.println(new T5最长回文子串_().longestPalindrome("a"));
    }

    public String longestPalindrome(String s) {

        String max = s.substring(0,0);
        int len = s.length();
        for (int i = 0; i < len - 1; i++) {

            String s1 = findmax(s, i, i);
            String s2 = findmax(s, i, i + 1);

            max = s1.length() > max.length() ? s1 : max;
            max = s2.length() > max.length() ? s2 : max;
        }

        return max;
    }

    private String findmax(String s, int m, int n) {
        while (m >= 0 && n < s.length()) {

            if (s.charAt(m) != s.charAt(n)) {
                break;
            }
            m--;
            n++;
        }

        return s.substring(m + 1, n);
    }

}
