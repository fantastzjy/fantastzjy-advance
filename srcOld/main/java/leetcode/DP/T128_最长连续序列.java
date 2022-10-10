package leetcode.DP;

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


        // 所以最好数遍历集合中每一个数 然后在这个数的而基础上进行相加 看集合中是否存在
        //遍历的过程中重复了无所谓 可能从下一个在向后遍历会更长

        for (int num : num_set) {
            //若有比该值小的就跳过  当没有比该值小的   说明该值是一段连续值得最小值，在进去找该值的递增数  可以减少计算
            //这一步是‘剪枝’  如果去这个数的前一个数在集合中出现过  说明这个数已经被遍历过了
            if (!num_set.contains(num - 1)) {
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

// 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence/solution/zui-chang-lian-xu-xu-lie-by-leetcode-solution/