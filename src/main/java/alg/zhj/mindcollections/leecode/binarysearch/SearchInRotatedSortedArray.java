package alg.zhj.mindcollections.leecode.binarysearch;

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 *
 * Created by zhaohongjie on 2019/2/6.
 */
public class SearchInRotatedSortedArray {

    /**
     * 旋转排序数组特点：每次二分必然会有一半数组是有序的。
     *
     * 算法思路：利用二分法切分后，
     * 1，判断左右哪部分数组是有序的；
     * 2，左侧有序——判断target是否在左侧区间内，是，在左侧进行二分查找；否，去右侧继续二分
     * 3，右侧有序——同上。
     *
     * 处理思路：如果在有序区间内，按二分查找；不在有序区间内，则继续二分
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {

        if (nums == null || nums.length <= 0) {
            return -1;
        }

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {

            int m = l + (r - l) / 2;

            if (nums[m] == target) {
                return m;
            }

            // 左侧有序
            if (nums[m] >= nums[l]) {

                if (nums[m] > target && target >= nums[l]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (nums[m] < target && target <= nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray obj = new SearchInRotatedSortedArray();
        int search = obj.search(new int[]{1, 3, 1, 1, 1}, 3);

        System.out.println(search);
    }
}
