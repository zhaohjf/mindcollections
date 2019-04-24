package alg.zhj.mindcollections.leecode.dynamic;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/coin-change/
 *
 * Created by zhaohongjie on 2019/2/25.
 */
public class CoinChange {

    /**
     * 转换为爬楼梯问题
     * dp[i] 表示 爬到第i层台阶需要走多少步
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {

        if (coins == null || coins.length <= 0) {
            return -1;
        }

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        dp[0]= 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    // 比较当前个数 与 前一个选择加1的个数  哪个大哪个小。
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange(new int[]{1, 2, 5}, 11));
    }
}
