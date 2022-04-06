package Leetcode.二分_labuladong.搜索旋转二分;

public class T33_搜索旋转排序数组_官方 {

    //我们根据 nums[mid] 与 target 的大小关系，可以得知 target 是在 mid 的左边还是右边，从而来调整左右边界 lo 和 hi。
    // 但是，对于旋转数组，我们无法直接根据 nums[mid] 与 target 的大小关系来判断 target 是在 mid 的左边还是右边，因此需要「分段讨论」。


    //基于二分法
    public int search(int[] nums, int target) {
        int n = nums.length;
        //base
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            //这里如果是 < 会导致如果只有两个元素，计算出来的 mid=0    对有序数组的判断是哪一边出错
            //若输入  [3,1] 1   则输出结果为 -1  对有序数组的判断错误进入else中 然后  r = mid - 1;  再也中不到目标值 1
            //if (nums[0] < nums[mid]) {

            //！！！思路：只有在有序的那一段 才能是升序（保证有序）  left 和 right才可根据  target与mid的大小进行移动
            //思路 找到有序的那一边 然后再进去判断 目标值是否在该段    因为有序才能参与比较  二分法！！！！
            // 先根据 nums[mid] 与 nums[l] 的关系判断 “mid” 是在左段还是右段
            //等于要包含在左边！！！！！！！！值相等则也判定为有序
            if (nums[l] <= nums[mid]) {
                // 再判断 target 是在 “mid” 的左边还是右边，从而调整左右边界 lo 和 hi
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}


//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems /search-in-rotated-sorted-array/solution/sou-suo-xuan-zhuan-pai-xu-shu-zu-by-leetcode-solut/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。