package alg.zhj.campaign.week05.practise;

/**
 *
 *
 * Created by zhaohongjie on 2020/7/8.
 */
public class FindPeakElement_162 {

    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if ((m == 0 || nums[m - 1] <= nums[m]) && (m == nums.length - 1 || nums[m] >= nums[m + 1])) {
                return m;
            } else if (nums[m] < nums[m + 1]) {
                l = m + 1;
            } else {
                r = m - 1;
            }

        }

        return -1;
    }

    public int _findPeakElement(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }
    public int search(int[] nums, int l, int r) {
        if (l == r)
            return l;
        int mid = (l + r) / 2;
        if (nums[mid] > nums[mid + 1])
            return search(nums, l, mid);
        return search(nums, mid + 1, r);
    }

    public int __findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}
