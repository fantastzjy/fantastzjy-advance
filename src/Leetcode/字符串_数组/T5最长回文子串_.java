package Leetcode.字符串_数组;


public class T5最长回文子串 {


    public String longestPalindrome(String s) {

        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String str1 = Palindrome(s, i, i);
            String str2 = Palindrome(s, i, i + 1);

            res = res.length() > str1.length() ? res : str1;
            res = res.length() > str2.length() ? res : str2;
        }

        return res;
    }

    //总结：不能盲目想着套模板
    private String Palindrome(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i)== s.charAt(j)) {
            i--;
            j++;
        }
        return s.substring(i + 1, j - 1);

    }
}
