package cn.zhj.mindcollections.leecode.binarysearch;

/**
 * https://leetcode-cn.com/problems/find-peak-element
 *
 * 非有序数组中，二分查找法的使用
 *
 * Created by zhaohongjie on 2019/2/4.
 */
public class FindPeakElement {

    /**
     * 只要求在一个数组里找出一个峰值元素并返回其下标，可以直接遍历数组查找，为使时间复杂度控制在O(log n)，可以采用二分查找，
     *
     * 首先找到中间节点mid，如果大于两边就返回当前下标index，如果左边的结点比mid大，那么继续在左半区间查找，这里面一定存在一个峰值元素，
     *
     * 因为nums[-1]为负无穷大；反之就继续在右半区间查找
     *
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {

        if (nums == null || nums.length <= 0) {
            return -1;
        }

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            /**
             * 避免數組越界
             */
//            if (m == 0 || m == nums.length - 1) {
//                return m;
//            }

            if ((m == 0 || nums[m - 1] <= nums[m]) && (m == nums.length - 1 || nums[m] >= nums[m + 1])) {
                return m;
            } else if (m < nums.length - 1 && nums[m] < nums[m + 1]) {
                l = m + 1;
            } else {
                r = m - 1;
            }

        }

        return -1;
    }

    /**
     * 输入: nums = [1,2,1,3,5,6,4]
     * 输出: 1 或 5
     * @param args
     */
    public static void main(String[] args) {
        FindPeakElement findPeakElement = new FindPeakElement();
        int peakElement = findPeakElement.findPeakElement(new int[]{3, 2});

        System.out.println(peakElement);
    }

}
