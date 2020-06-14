package alg.zhj.monographicstudy.fivetimes.knapsack;

/**
 * Created by zhaohongjie on 2020/4/18.
 */
public class Knapsack01_TwoPartition {

    private boolean knapsack(int[] nums,int sum){

        int size = nums.length;
        boolean[] dp = new boolean[sum + 1];
        for (int i = 0;i <= sum;i ++){
            dp[i] = i == nums[0];
        }

        for (int i = 1;i < size;i++){
            for (int j = sum;j >= nums[i];j--){
                dp[j] = dp[j] || dp[j-nums[i]];
            }
        }
        return dp[sum];
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int item : nums){
            sum += item;
        }

        //如果数组元素和不是2的倍数，直接返回false
        if (sum % 2 != 0)
            return false;

        return knapsack(nums,sum/2);
    }

    public static void main(String[] args) {
        Knapsack01_TwoPartition obj = new Knapsack01_TwoPartition();
        System.out.println(obj.canPartition(new int[]{1, 5, 11, 15}));
    }
}
