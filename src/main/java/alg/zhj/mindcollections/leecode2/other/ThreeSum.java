package alg.zhj.mindcollections.leecode2.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/3sum/
 *
 * Created by zhaohongjie on 2019/4/22.
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length <= 3) {
            return res;
        }

        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {

            if (nums[i] + nums[i + 1] + nums[i + 2] > 0) {
                break;
            }

            if (nums[i] + nums[n - 2] + nums[n - 1] < 0) {
                continue;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int l = i + 1;
            int r = n - 1;
            while (l < r) {

            }
        }

        return res;
    }
}
