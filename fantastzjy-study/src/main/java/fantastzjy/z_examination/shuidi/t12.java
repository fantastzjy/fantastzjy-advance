package fantastzjy.z_examination.shuidi;


import java.util.Arrays;

public class t12 {

    public int compute(int[] nums, int target) {

        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {

            for (int j = nums.length - 1; j > i; j--) {

                int res = nums[i] * nums[j];
                if (res == target) {
                    count++;
                } else if (res < target) {
                    //右边在向前已经不可能有
                    break;
                }

            }
        }
        return count;

    }

}

