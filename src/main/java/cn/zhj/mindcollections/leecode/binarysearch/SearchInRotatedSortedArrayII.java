package cn.zhj.mindcollections.leecode.binarysearch;

/**
 * Created by zhaohongjie on 2019/2/12.
 */
public class SearchInRotatedSortedArrayII {

    /**
     * 跟第一题思路一样的. 只是这里需要考虑旋转点在重复元素之间的情况, 这种情况就是两端向内夹逼去掉重复元素, 转化成第一题
     *
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return false;
        }

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {

            /**
             * 夹逼去重的边界条件很是不好搞
             *
             */
            if (l != r && nums[l] == nums[r]) {
                ++l;
                while (l < r && nums[l] == nums[l - 1]) {
                    ++l;
                }
                while (r > l && nums[r] == nums[r - 1]) {
                    --r;
                }
            }

            int m = l + (r - l) / 2;

            if (nums[m] == target) {
                return true;
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

        return false;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArrayII obj = new SearchInRotatedSortedArrayII();
        boolean result = obj.search(new int[]{0,0,1,1,1,3}, 0);

        System.out.println(result);
    }
}
