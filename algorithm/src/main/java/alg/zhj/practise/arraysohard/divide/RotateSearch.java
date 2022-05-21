package alg.zhj.practise.arraysohard.divide;

public class RotateSearch {

    /**
     * 先判断右侧有序，可以考虑下如果先判断左侧有序要怎么做
     *
     * 整体思路就是，二分以后，100%会有一侧是有序的，先处理有序一侧，可以得到一个信息是，在右侧、或者不在右侧。
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (target == nums[mid]) {
                return mid;
            }
            // 右侧有序
            if (nums[r] >= nums[mid]) {
                // 右侧有序，那先判断是否在右侧范围内，这是一个准确信息，要放在最前面应用
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            // 左侧有序
            else {
                if (target < nums[mid] && target >= nums[l]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        RotateSearch obj = new RotateSearch();
        int search = obj.search(nums, 0);
        System.out.println(search);
    }
}
