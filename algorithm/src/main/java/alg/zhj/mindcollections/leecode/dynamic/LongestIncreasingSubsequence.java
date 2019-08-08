package alg.zhj.mindcollections.leecode.dynamic;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 *
 * Created by zhaohongjie on 2019/2/24.
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {

        if (nums == null || nums.length <= 0) {
            return 0;
        }

        int res = 1;

        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    /**
     * 没用二分查找的情况下，时间复杂度为0ms，应该是数据集较小原因
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS_0(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int last = 0;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                dp[0] = nums[0];
            } else if (dp[last] < nums[i]) {
                dp[++last] = nums[i];
            } else {
                for (int j = 0; j <= last; j++) {
                    if (dp[j] >= nums[i]) {
                        dp[j] = nums[i];
                        break;
                    }
                }
            }
        }
        return last + 1;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence();
        System.out.println(obj.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }
}
