package leetcode.dp;

//时间 O(n^2)
//空间 O(1)
public class T5_最长回文子串_中心扩展算法_练习 {

    //证明  substring左闭右开
    public static void main(String[] args) {
        System.out.println("01234567".substring(0, 2));
    }

    public String longestPalindrome(String s) {

        if (s == null && s.length() < 1) {
            return null;
        }

        //int max = 0;
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = huiwen(s, i, i);
            int len2 = huiwen(s, i, i + 1);
            int len = Math.max(len1, len2);
            //直接使用start end 便于更新  不管是大于等于end-start+1就更新 还是大于end-start+1在更新都一样，只需返回最大长度就行
            if (len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }


        return s.substring(start, end + 1);  //该函数左闭右开
    }

    private int huiwen(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            //i++;    ！！！！！！！！！！！！！！！
            i--;
            j++;
        }
        return j - i - 1;
    }
}