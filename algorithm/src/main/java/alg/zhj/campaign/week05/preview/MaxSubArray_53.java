package alg.zhj.campaign.week05.preview;

/**
 * Created by zhaohongjie on 2020/7/13.
 */
public class MaxSubArray_53 {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int ans = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = Math.max(res + nums[i], nums[i]);
            ans = Math.max(ans, res);
        }

        return ans;
    }

    /**
     * 输入: [-2,1,-3,4,-1,2,1,-5,4],
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     *
     * @param args
     */
    public static void main(String[] args) {

    }
}
