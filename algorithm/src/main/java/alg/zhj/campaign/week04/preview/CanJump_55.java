package alg.zhj.campaign.week04.preview;

/**
 * Created by zhaohongjie on 2020/6/28.
 */
public class CanJump_55 {

    /**
     * 哈哈~~~虽然垃圾，但好歹也通过了
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = Math.max(count, nums[i]);
            if (count == 0) {
                return false;
            }
            if (count >= nums.length - i - 1) {
                return true;
            }
            count--;
        }
        return false;
    }

    public boolean _canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean canJump(int A[], int n) {
        int i = 0;
        for (int reach = 0; i < n && i <= reach; ++i)
            reach = Math.max(i + A[i], reach);
        return i == n;
    }

    public boolean __canJump(int[] nums) {
        int m = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > m) {
                return false;
            }
            m = Math.max(m, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = {2, 0, 0};
        CanJump_55 obj = new CanJump_55();
        System.out.print(obj.canJump(a));
    }
}
