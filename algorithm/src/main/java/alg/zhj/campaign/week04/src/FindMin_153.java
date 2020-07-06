package alg.zhj.campaign.week04.src;

/**
 * Created by zhaohongjie on 2020/7/4.
 */
public class FindMin_153 {

    /**
     * 这是找翻转点，不是最小值
     *
     * @param nums
     * @return
     */
    public int findReverseP(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >>> 1);
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            if (nums[0] <= nums[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public int findMin(int[] nums) {

        if (nums == null || nums.length <= 0) {
            return -1;
        }

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {

            int m = l + (r - l) / 2;

            if ((m <= l || nums[m - 1] >= nums[m]) && (m >= r || nums[m + 1] >= nums[m])) {
                return nums[m];
            }

            if (nums[m] >= nums[l] && nums[m] >= nums[r]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return -1;
    }

    public int _findMin(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + ((r - l) >>> 1);
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }

    public int __findMin(int[] nums) {
        // If the list has just one element then return that element.
        if (nums.length == 1) {
            return nums[0];
        }

        // initializing left and right pointers.
        int left = 0, right = nums.length - 1;

        // if the last element is greater than the first element then there is no rotation.
        // e.g. 1 < 2 < 3 < 4 < 5 < 7. Already sorted array.
        // Hence the smallest element is first element. A[0]
        if (nums[right] > nums[0]) {
            return nums[0];
        }

        // Binary search way
        while (right >= left) {
            // Find the mid element
            int mid = left + (right - left) / 2;

            // if the mid element is greater than its next element then mid+1 element is the smallest
            // This point would be the point of change. From higher to lower value.
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            // if the mid element is lesser than its previous element then mid element is the smallest
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            // if the mid elements value is greater than the 0th element this means
            // the least value is still somewhere to the right as we are still dealing with elements
            // greater than nums[0]
            if (nums[mid] > nums[0]) {
                left = mid + 1;
            } else {
                // if nums[0] is greater than the mid value then this means the smallest value is somewhere to
                // the left
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindMin_153 obj = new FindMin_153();
        System.out.print(obj.findMin(new int[]{1}));
    }
}
