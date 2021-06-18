package leetcode;

public class T69_x的平方根 {


//官方正解
//官方答案是将等于的情况和小于情况合并了
// 这样当 while循环的条件不符合时  返回的ans 就是最接近答案的 ！！！妙啊

    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        //二分的条件是  l <= r   因为可能当等于时可能正好左右都到这个值
        while (l <= r) {
            int mid = l + (r - l) / 2;
            //注意这里 防止越界 情之转化为long 如果是写成 mid < x / mid  可能报错除0异常
            //如果小于 就l+mid    l++的平方始终比 r+mid时的平方小  最终循环终止条件
            //注意每次l和r 都是  在mid的基础上加减1
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }

}