package leetcode.数学;

//https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/
public class Offer56_数组中数字出现的次数II {
    //在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。找出那个只出现一次的数字。

    public static void main(String[] args) {
        Offer56_数组中数字出现的次数II.singleNumber(new int[]{3, 4, 3, 3});
    }

    public static int singleNumber(int[] nums) {
        int bitmask = (1 << 31) - 1;  //最左边是1 后面31位是0
        int res = 0;
        for (int i = 0; i < 31; i++) {
            int sum = 0;
            for (int num : nums) {
                if ((bitmask & num) == 1) {
                    sum++;
                }
            }
            res = res << 1 + sum % 3;
            bitmask >>= 1;
        }
        return res;
    }
}