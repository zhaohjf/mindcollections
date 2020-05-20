package alg.zhj.mindcollections.interview.array;

/**
 * Created by zhaohongjie on 2020/5/20.
 */
public class MaxProduct_leetcode152 {

    /**
     * 我们只要记录前i的最小值, 和最大值, 那么
     * dp[i] = max(nums[i] * pre_max, nums[i] * pre_min, nums[i]),
     * 这里0 不需要单独考虑, 因为当相乘不管最大值和最小值,都会置0
     *
     * dp详细版本
     * @see alg.zhj.mindcollections.leecode.dynamic.MaximumProductSubarray
     *
     * @param nums
     * @return
     */
    public int maxProduct_dp(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = nums[0];
        int min = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(min * nums[i], temp * nums[i]), nums[i]);
            res = Math.max(res, max);
        }

        return res;
    }

    public static void main(String[] args) {
        MaxProduct_leetcode152 obj = new MaxProduct_leetcode152();
        int i = obj.maxProduct_dp(new int[]{-4, -3, -2});
        System.out.print(i);
    }
}
