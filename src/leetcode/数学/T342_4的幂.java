package leetcode.数学;

public class T342_4的幂 {
    // Binary Search
    // @爱学习的饲养员
    // Time Complexity: O(log n)
    // Space Complexity: O(1)
    //https://www.bilibili.com/video/BV1rQ4y1R7KZ?spm_id_from=333.999.0.0
    //二分法
    class s1 {
        public boolean isPowerOfFour(int n) {
            if (n < 1) {
                return false;
            }
            int l = 0;
            int r = n;

            while (l <= r) {
                int mid = l + (r - l) / 2;
                long res = (long) Math.pow(4, mid);
                if (res == n) {
                    return true;
                } else if (res < n) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return false;
        }
    }

    //位运算
    //位运算 只有两个都是1 相与结果才是1 其他都是0！！！
    class s2 {
        //2的幂次方的数 n 与 n-1 的数 & 结果都是0  在该前提下，4的幂的数 n%3 结果为1！！！！！！！
        // Bit Manipulation
        // @爱学习的饲养员
        // Time Complexity: O(1)！！！  因为就一个计算 没有循环！！!
        // Space Complexity: O(1)！！！
        public boolean isPowerOfFour(int n) {
            if (n < 1) {
                return false;
            }
            //注意优先级
            //利用  如果一个数是2的幂次方 n & (n - 1)  一定等于0   再利用4%3==1  的特性判断是否是4的幂次方
            //return n & (n - 1) == 0 && n % 3 == 1;
            return (n & (n - 1)) == 0 && n % 3 == 1;
        }
    }
}