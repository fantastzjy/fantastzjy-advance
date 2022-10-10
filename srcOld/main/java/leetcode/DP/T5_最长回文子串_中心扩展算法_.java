package leetcode.DP;

//时间 O(n^2)
//空间 O(1)
public class T5_最长回文子串_中心扩展算法_ {

    public String longestPalindrome(String s) {

        if (s == null && s.length() < 2) {
            return null;
        }

        int start = 0, end = 0, maxlen = 1;
        int len = s.length();

        for (int i = 0; i < len; i++) {

            maxlen = Math.max(sub(s, i, i), sub(s, i, i + 1));

            if (maxlen > end - start + 1) {
                start = i - (maxlen - 1) / 2;
                end = i + maxlen / 2;
            }
        }
        return s.substring(start, end + 1);
    }


    private int sub(String s, int i, int j) {

        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }
}