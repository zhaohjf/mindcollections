package cn.zhj.mindcollections.leecode.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum-iv/
 *
 * Created by zhaohongjie on 2019/2/3.
 */
public class CombinationSumIV {

    public int combinationSum4(int[] nums, int target) {

        if (nums == null || nums.length <= 0) {
            return 0;
        }

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        dfs(result, new ArrayList<Integer>(), nums, target, 0);

        return result.size();
    }

    private void dfs(List<List<Integer>> result, List<Integer> temp, int[] nums, int target, int level) {

        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        if (target < nums[0]) {
            return;
        }

        for (int i = 0; i < nums.length && target >= nums[i]; i++) {

            temp.add(nums[i]);
            dfs(result, temp, nums, target - nums[i], i);
            temp.remove((Integer) nums[i]);
        }
    }

    /**
     * 简单递归会超时
     *
     * @param args
     */
    public static void main(String[] args) {
        CombinationSumIV combinationSumIV = new CombinationSumIV();
        int result = combinationSumIV.combinationSum4_dy(new int[]{4, 2, 1}, 32);

        System.out.println(result);
    }

    /**
     * 这种写法很简单，可以重点借鉴下。。。。
     *
     * 简单递归
     */
    public int combinationSum4_1(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        int res = 0;
        for (int num : nums) {
            if (target >= num) {
                res += combinationSum4_1(nums, target - num);
            }
        }
        return res;
    }

    /**
     * 记忆化搜索
     */
    private int[] memo;

    public int combinationSum4_2(int[] nums, int target) {
        memo = new int[target + 1];
        Arrays.fill(memo, -1);
        memo[0] = 1;
        return search(nums, target);
    }

    private int search(int[] nums, int target) {
        if (memo[target] != -1) {
            return memo[target];
        }
        int res = 0;
        for (int num : nums) {
            if (target >= num) {
                res += search(nums, target - num);
            }
        }
        memo[target] = res;
        return res;
    }

    /**
     * 动态规划
     */
    public int combinationSum4_dy(int[] nums, int target) {
        int[] memo = new int[target + 1];
        memo[0] = 1;
        for (int i = 0; i < target; i++) {
            for (int num : nums) {
                if (i + num <= target) {
                    memo[i + num] += memo[i];
                }
            }
        }
        return memo[target];
    }
}
