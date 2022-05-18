package alg.zhj.practise.backtracking;

/**
 * https://leetcode.cn/problems/house-robber/
 */
public class Rob {

    public int rob(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }

    public static void main(String[] args) {
        Rob obj = new Rob();
        System.out.println(obj.rob(new int[]{1, 2, 3, 1}));
    }
}
