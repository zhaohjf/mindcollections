package alg.zhj.monographicstudy.fivetimes.knapsack;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 * <p>
 * Created by zhaohongjie on 2020/4/18.
 */
public class CanPartition {

    public boolean canPartition(int[] nums) {

        if (nums.length == 1) {
            return false;
        }

        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum / 2;

        // 创建二维状态数组，行：物品索引，列：容量（包括 0）
        boolean[][] dp = new boolean[nums.length][target + 1];

        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                // 直接从上一行先把结果抄下来，然后再修正
                dp[i][j] = dp[i - 1][j];

                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }
                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }

        return dp[nums.length - 1][target];
    }

    /**
     * 运行时间是最快的 leetcode 0ms 复习时值得研究下。。。
     *
     * @param nums
     * @return
     */
    public boolean canPartition_dfs(int[] nums) {

        int maxnum = 0;
        int sum = 0;
        for (int num : nums) {//一次遍历先找出最大值和总和
            sum += num;
            maxnum = Math.max(maxnum, num);
        }
        int target;

        if (sum % 2 != 0) {//如果总和是奇数就肯定不行
            return false;
        } else {
            target = sum / 2;//计算出等和数组的目标数
        }

        if (maxnum > target) {//如果数组中的最大值大于这个目标值，肯定就不行了
            return false;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == target) {//如果当前值等于目标值，就可以
                return true;
            }
            if (dfs(i, nums[i], nums, target)) {
                return true;
            }
        }
        //走完了循环还没有，就是不行
        return false;
    }

    private boolean dfs(int i, int cur, int[] nums, int target) {

        //进来之后，去遍历前面可用的元素
        for (int j = i - 1; j >= 0; j--) {
            if (nums[j] + cur == target) {
                return true;
            }
            if (nums[j] + cur > target) {
                continue;//说明当前这个数不符合，跳出循环继续找去
            }
            if (dfs(j, nums[j] + cur, nums, target)) {//走到这里说明当前这个值加上当前回溯的值小于target，再往深里走
                return true;
            }
        }

        return false;
    }

    public boolean canPartition_dfs2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        if((sum &1) ==1) {
            return false;
        }
        sum>>=1;
        Arrays.sort(nums);
        return callBack(sum,nums,len,sum);

    }

    public boolean callBack(int value,int [] nums,int index,int sum1) {
        // System.out.println("value "+value+" index "+index);
        if (value == 0 || sum1 == 0) {
            // System.out.println("v  "+nums[index]);
            return true;
        }
        if (value < 0 || sum1 < 0) {
            return false;
        }
        int i = index - 1;
        // System.out.println(i+" ~~~~");
        return callBack(value - nums[i], nums, i,sum1) || callBack(value, nums, i,sum1-nums[i]);
    }

}
