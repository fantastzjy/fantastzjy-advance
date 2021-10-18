package leetcode.dp;

//时间 O(n^2)
//空间 O(1)
public class T5_最长回文子串_中心扩展算法 {

    public String longestPalindrome(String s) {
        //字符串类型的basecase
        if (s == null || s.length() < 1) {
            return "";
        }

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            //计算首尾下标
            //如果长度大于当前最大值
            //直接使用start end 便于更新  不管是大于等于end-start+1就更新 还是大于end-start+1在更新都一样，只需返回最大长度就行
            if (len > end - start) {
                //如果子串长度是偶数 2 起始位置是 i
                //如果子串长度是奇数 3 起始位置是 i-1
                start = i - (len - 1) / 2;
                end = i + len / 2;    //不管奇偶 都是加上长度/2  因为i 是奇/偶 中心的 ’左‘ 中心
            }
        }
        return s.substring(start, end + 1);//该函数左闭右开
    }

    public int expandAroundCenter(String s, int left, int right) {
        //不越界并且相等
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            //i++;    ！！！！！！！！！！！！！！！
            left--;
            right++;
        }
        //当不满足条件时 left和right加起来多2  本来长度是right-left+1    要减去多计算的长度
        return right - left - 1;
    }
}

//作者：LeetCode-Solution
// https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zui-chang-hui-wen-zi-chuan-by-leetcode-solution/