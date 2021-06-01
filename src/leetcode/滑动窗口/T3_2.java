package leetcode.滑动窗口;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */

public class T3_2 {

    public int lengthOfLongestSubstring(String s) {

        if (s != null && "".equals(s)) {
            return 0;
        }

        Set<Character> set = new HashSet<>();

        int res = 0;
        //第一轮循环 时 r = -1    则添加进去的会是s.charAt(0)
        int l = 0, r = -1;
        for (l = 0; l < s.length(); l++) {

            if (l != 0) {
                //当第二次进入该循环时 l已经加过了 要移除上一个
                set.remove(s.charAt(l - 1));
            }

            //不能写成r=r+1  在判断的时候r的孩子不能改变 注意是!set.contains
            while (r + 1 < s.length() && !set.contains(s.charAt(r + 1))) {
                set.add(s.charAt(r + 1));  //这里是r+1 ！！！
                r++;
            }

            //长度的确定不再用一个局部变量去存储  用区间长度
            res = Math.max(res, r - l + 1);

        }

        return res;

    }
}
