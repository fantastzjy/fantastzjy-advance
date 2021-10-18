package leetcode.dp;

import java.util.HashSet;
import java.util.Set;

//时间空间复杂度都是on
public class T128_最长连续序列 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        //由于不是连续的 也不确定数字大小  不能用fori
        // 所以最好数遍历集合中每一个数 然后在这个数的而基础上进行相加 看集合中是否存在
        //遍历的过程中重复了无所谓 可能从下一个在向后遍历会更长
        //for (int num : nums) {  经测试 hash的遍历比数组快很多  这里遍历hash
        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {  //这一步是‘剪枝’  如果去这个数的前一个数在集合中出现过  说明这个数已经被遍历过了
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}

//作者：LeetCode-Solution
//        链接：https://leetcode-cn.com/problems/longest-consecutive-sequence/solution/zui-chang-lian-xu-xu-lie-by-leetcode-solution/