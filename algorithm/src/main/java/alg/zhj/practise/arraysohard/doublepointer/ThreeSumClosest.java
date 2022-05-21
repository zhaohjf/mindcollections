package alg.zhj.practise.arraysohard.doublepointer;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/3sum-closest/
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    l++;
                } else {
                    r--;
                }
                ans = Math.abs(sum - target) < Math.abs(ans - target) ? sum : ans;
            }
        }
        return ans;
    }
}
