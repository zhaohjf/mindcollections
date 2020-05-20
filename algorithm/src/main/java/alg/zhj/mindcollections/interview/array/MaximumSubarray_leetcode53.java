package alg.zhj.mindcollections.interview.array;

/**
 * Created by zhaohongjie on 2020/5/20.
 */
public class MaximumSubarray_leetcode53 {

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

    public static void main(String[] args) {
        MaximumSubarray_leetcode53 obj = new MaximumSubarray_leetcode53();
        System.out.println(obj.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
