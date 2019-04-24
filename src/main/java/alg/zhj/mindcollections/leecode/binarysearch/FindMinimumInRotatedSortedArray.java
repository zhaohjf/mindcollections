package alg.zhj.mindcollections.leecode.binarysearch;

/**
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 *
 * 旋转数组的二分查找法
 *
 * Created by zhaohongjie on 2019/2/12.
 */
public class FindMinimumInRotatedSortedArray {

    /**
     * 假设 nums[-1] = nums[n] = +∞, 并不成立；反例{2, 3, 4, 5, 1}
     *
     * 按照升序排序的数组在预先未知的某个点上进行了旋转
     *
     * 搜索波谷位置
     *
     * 难点：在确定向左，还是向右移动时情况相对复杂些
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {

        if (nums == null || nums.length <= 0) {
            return -1;
        }

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {

            int m = l + (r - l) / 2;

            // 最小元素出现在其左右元素都大于自身的位置上
            if ((m <= l || nums[m - 1] >= nums[m]) && (m >= r || nums[m + 1] >= nums[m])) {
                return nums[m];
            }

            /**
             * 利用有序数组旋转这个特性。
             *
             * 如果中间元素值都大于区间头尾元素的值，那么根据旋转的特性，我们可以知道较小的值一定是在右侧的！！！！
             */
            if (nums[m] >= nums[l] && nums[m] >= nums[r]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray obj = new FindMinimumInRotatedSortedArray();
        int min = obj.findMin(new int[]{2, 3, 4, 5, 1});

        System.out.println(min);
    }

}
