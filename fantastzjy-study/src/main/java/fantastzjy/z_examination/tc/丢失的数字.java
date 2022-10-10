package fantastzjy.z_examination.tc;

/**
 * @Package: 笔试.tc
 * @ClassName: 丢失的数字
 * @Author: jiaying2.zhang
 * @CreateTime: 2022-1-7 10:59
 * @Description:
 */
public class 丢失的数字 {

    public static int missingNumber(int[] nums) {
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            res = res ^ nums[i] ^ i;
        }

        res ^= nums.length;

        return res;
    }
}