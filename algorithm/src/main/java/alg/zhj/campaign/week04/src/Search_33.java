package alg.zhj.campaign.week04.src;

/**
 * Created by zhaohongjie on 2020/7/2.
 */
public class Search_33 {

    /**
     * bad case
     *
     * @param nums
     * @param target
     * @return
     */
    public int _search(int[] nums, int target) {

        if (nums == null || nums.length <= 0) {
            return -1;
        }

        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >>> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target && nums[l] <= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {

        if (nums == null || nums.length <= 0) {
            return -1;
        }

        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >>> 1);
            if (nums[mid] == target) {
                return mid;
            }
            // 左侧有序
            // 注意是 >= 当只有自身一个元素时，也是左侧有序的
            if (nums[mid] >= nums[l]) {
                if (nums[mid] > target && nums[l] <= target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && nums[r] >= target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Search_33 obj = new Search_33();
        System.out.println(obj.search(new int[]{3,1}, 1));

    }
}
