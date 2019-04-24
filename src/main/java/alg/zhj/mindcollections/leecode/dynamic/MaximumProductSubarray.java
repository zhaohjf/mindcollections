package alg.zhj.mindcollections.leecode.dynamic;

/**
 * https://leetcode-cn.com/problems/maximum-product-subarray
 *
 * Created by zhaohongjie on 2019/2/21.
 */
public class MaximumProductSubarray {

    static int res = 0;

    public int maxProduct_recurse(int[] nums) {

        dfs(nums, true, 1, 0);
        dfs(nums, false, 1, 0);

        return res;
    }

    private void dfs(int[] nums, boolean product, int sum, int index) {

        if (index == nums.length) {
            return;
        }

        if (product) {
            sum = sum * nums[index];
            if (sum > res) {
                res = sum;
            }
        } else {
            sum = 1;
        }

        dfs(nums, true, sum, index + 1);
        dfs(nums, false, sum, index + 1);
    }

    public int maxProduct(int[] nums) {

        int res = 0;

        if (nums == null || nums.length <= 0) {
            return res;
        }

        int[][] dp = new int[2][2];

        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        res = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int x = i % 2;
            int y = (i - 1) % 2;

            // TODO 怎么体现连续子数组

            dp[x][0] = Math.max(nums[i], Math.max(dp[y][0] * nums[i], dp[y][1] * nums[i]));
            dp[x][1] = Math.min(nums[i], Math.min(dp[y][0] * nums[i], dp[y][1] * nums[i]));

            res = Math.max(res, dp[x][0]);
        }

        return res;
    }

    public static void main(String[] args) {
        MaximumProductSubarray obj = new MaximumProductSubarray();
        System.out.println(obj.maxProduct(new int[]{-2, -3, 0, -1, 3, 2, -1, 2}));
    }
}
