package Leetcode.数学;

// https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
public class Offer56_数组中数字出现的次数 {
    //一个整型数组 nums 里有两个数字只出现一次，其他数字都出现了两次。找出这两个只出现一次的数字。
    // 要求时间复杂度是O(n)，空间复杂度是O(1)。


    //大佬总结
    //https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/solution/jie-di-qi-jiang-jie-fen-zu-wei-yun-suan-by-eddievi/
    public int[] singleNumbers(int[] nums) {
        //xor用来计算nums的异或和
        int xor = 0;

        // 计算异或和 并存到xor
        // e.g. [2,4,2,3,3,6] 异或和：(2^2)^(3^3)^(4^6)=2=010
        for (int num : nums) xor ^= num;

        //设置mask为1，则二进制为0001
        // mask是一个二进制数，且其中只有一位是1，其他位全是0，比如000010，
        // 表示我们用倒数第二位作为分组标准，倒数第二位是0的数字分到一组，倒数第二位是1的分到另一组
        int mask = 1;

        // & operator只有1&1时等于1 其余等于0
        // 用上面的e.g. 4和6的二进制是不同的 我们从右到左找到第一个不同的位就可以分组 4=0100 6=0110
        // 根据e.g. 010 & 001 = 000 = 0则 mask=010
        // 010 & 010 != 0 所以mask=010
        // 之后就可以用mask来将数组里的两个数分区分开
        while ((xor & mask) == 0) {
            mask <<= 1;
        }

        //两个只出现一次的数字
        int a = 0, b = 0;

        for (int num : nums) {
            //根据&是否为0区分将两个数字分区，并分别求异或和
            if ((num & mask) == 0) a ^= num;
            else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }


    //官方
    //思路
    //先对所有数字进行一次异或，得到两个出现一次的数字的异或值。
    //在异或结果中找到任意为 11 的位。
    //根据这一位对所有的数字进行分组。
    //在每个组内进行异或操作，得到两个数字。
    //链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/solution/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-by-leetcode/

    public int[] singleNumbers2(int[] nums) {
        int ret = 0;
        for (int n : nums) {
            ret ^= n;
        }
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }
        int a = 0, b = 0;
        for (int n : nums) {
            if ((div & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};

    }
}