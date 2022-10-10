package fantastzjy.leetcode.二分_labuladong;

public class 二分法 {

    //基于二分法
    public int search(int[] nums, int target) {
        int len = nums.length;
        //base
        if (len == 0) {
            return -1;
        }

        int l = 0, r = len - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}

//解析：
//链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/sou-suo-xuan-zhuan-pai-xu-shu-zu-by-leetcode-solut/