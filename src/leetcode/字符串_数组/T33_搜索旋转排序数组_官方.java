package leetcode.字符串_数组;

public class T33_搜索旋转排序数组_官方 {

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

            //因为上面已经判断mid位置的数不等于target所以下面判断不是大于就是小于
            //这里如果是 < 会导致如果只有两个元素，计算出来的 mid=0    对有序数组的判断是哪一边出错
            //若输入  [3,1] 1   则输出结果为 -1  对有序数组的判断错误进入else中 然后  r = mid - 1;  再也中不到目标值 1
            //if (nums[0] < nums[mid]) {
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
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
//链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/sou-suo-xuan-zhuan-pai-xu-shu-zu-by-leetcode-solut/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。