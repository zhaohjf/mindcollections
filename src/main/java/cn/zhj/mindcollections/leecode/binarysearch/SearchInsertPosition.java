package cn.zhj.mindcollections.leecode.binarysearch;

/**
 * https://leetcode-cn.com/problems/search-insert-position/
 *
 * Created by zhaohongjie on 2019/2/4.
 */
public class SearchInsertPosition {

    /**
     * 已知是有序数组，求元素位置——很明显是一个二分查找的问题空间
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {

        if (nums == null || nums.length <= 0) {
            return 0;
        }

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return l;
    }

    public static void main(String[] args) {

        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        int res = searchInsertPosition.searchInsert(new int[]{1, 3, 5, 6}, 7);

        System.out.println(res);
    }
}
