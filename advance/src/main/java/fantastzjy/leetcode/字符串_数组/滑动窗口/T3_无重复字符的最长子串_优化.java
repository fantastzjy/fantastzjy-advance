package fantastzjy.leetcode.字符串_数组.滑动窗口;

import java.util.HashMap;

//滑动窗口
//使用hashmap更方便可直接直到重复元素的位置
public class T3_无重复字符的最长子串_优化 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                //重复的一定只有一个   直接将找到的位置然后+1 就是left的位置
                //这里之前的疑惑是 上面并不能把left的位置移动到没有重复的最右边  没想到只可能有一个重复的
                left = Math.max(left, map.get(s.charAt(i)) + 1);

                //等同于上面一行
                //Integer index = map.get(s.charAt(i));
                //等于时说明最左边包含！！！！！！！！！！！！！
                //if (index >= left) {
                //    left = index + 1;
                //}

            }

            //这里很巧妙！！！！！   把重复的char的位置更新了 不用删除就行  相当于变相的删除旧的key
            // 用character做为key 利用key只有一个的特性 确保char只有一个

            //不管是否更新left，都要更新 s.charAt(i) 的位置！   map里面的元素不用剔除  因为left控制左边！
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;

    }
}

// https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/hua-dong-chuang-kou-by-powcai/


/**
 * 别人的笔记
 * 1、首先，判断当前字符是否包含在map中，如果不包含，将该字符添加到map（字符，字符在数组下标）,
 * 此时没有出现重复的字符，左指针不需要变化。此时不重复子串的长度为：i-left+1，与原来的maxLen比较，取最大值；
 * <p>
 * 2、如果当前字符 ch 包含在 map中，此时有2类情况：
 * 1）当前字符包含在当前有效的子段中，如：abca，当我们遍历到第二个a，当前有效最长子段是 abc，我们又遍历到a，
 * 那么此时更新 left 为 map.get(a)+1=1，当前有效子段更新为 bca；
 * 2）当前字符不包含在当前最长有效子段中，如：abba，我们先添加a,b进map，此时left=0，我们再添加b，发现map中包含b，
 * 而且b包含在最长有效子段中，就是1）的情况，我们更新 left=map.get(b)+1=2，此时子段更新为 b，而且map中仍然包含a，map.get(a)=0；
 * 随后，我们遍历到a，发现a包含在map中，且map.get(a)=0，如果我们像1）一样处理，就会发现 left=map.get(a)+1=1，实际上，left此时
 * 应该不变，left始终为2，子段变成 ba才对。
 * <p>
 * 为了处理以上2类情况，我们每次更新left，left=Math.max(left , map.get(ch)+1).
 * 另外，更新left后，不管原来的 s.charAt(i) 是否在最长子段中，我们都要将 s.charAt(i) 的位置更新为当前的i，
 * 因此此时新的 s.charAt(i) 已经进入到 当前最长的子段中！
 */