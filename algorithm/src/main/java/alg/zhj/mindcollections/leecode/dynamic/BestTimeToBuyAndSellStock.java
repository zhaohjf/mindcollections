package alg.zhj.mindcollections.leecode.dynamic;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 *
 * Created by zhaohongjie on 2019/2/21.
 */
public class BestTimeToBuyAndSellStock {

    /**
     * dp[i][j] i取舍为0，1进行状态压缩；j取值 0 记录[0,i]利润最大值，1 记录[0,i]中价格最小值。
     *
     * @param prices
     * @return
     */
    public int maxProfit_ordinary(int[] prices) {

        int res = 0;

        if (prices == null || prices.length <= 1) {
            return res;
        }

        int[][] dp = new int[2][2];

        dp[0][0] = 0;
        dp[0][1] = prices[0];

        for (int i = 1; i < prices.length; i++) {

            int x = i % 2;
            int y = (i - 1) % 2;

            dp[x][0] = Math.max(dp[y][0], prices[i] - dp[y][1]);
            dp[x][1] = Math.min(dp[y][1], prices[i]);

            res = Math.max(res, dp[x][0]);
        }

        return res;
    }

    public int maxProfit_qingchao(int[] prices) {

        int res = 0;

        if (prices == null || prices.length <= 1) {
            return res;
        }

        int[][] profit = new int[prices.length][3];

        // 第0天没有买入
        profit[0][0] = 0;

        // 第0天买入
        profit[0][1] = -prices[0];

        // 第0天卖出
        profit[0][2] = 0;

        for (int i = 1; i < prices.length; i++) {
            profit[i][0] = profit[i - 1][0];
            profit[i][1] = Math.max(profit[i - 1][1], profit[i - 1][0] - prices[i]);
            profit[i][2] = profit[i - 1][1] + prices[i];

            res = Math.max(res, Math.max(profit[i][0], profit[i][2]));
        }

        return res;
    }

    /**
     * 状态压缩
     *
     * profit[i][j] i 表示前i个价格中；j 代表 0 空仓最大利润，1 持仓最大利润
     *
     * 由于题目只允许买入卖出一次，所以它的状态转移方程，同后面状态转移方程有很大不同。
     *
     * @param prices
     * @return
     */
    public int maxProfit_compress(int[] prices) {

        int res = 0;

        if (prices == null || prices.length <= 1) {
            return res;
        }

        int[][] profit = new int[2][3];

        profit[0][0] = 0;
        profit[0][1] = -prices[0];
        profit[0][2] = 0;

        for (int i = 1; i < prices.length; i++) {

            int x = i % 2;
            int y = (i - 1) % 2;

            // 由于只允许买卖一次，所以如果当前为没有买入，那之前也不可能有买入，所有直接等于前面一个值即可
            profit[x][0] = profit[y][0];
            profit[x][1] = Math.max(profit[y][1], profit[y][0] - prices[i]);
            profit[x][2] = profit[y][1] + prices[i];

            res = Math.max(res, Math.max(profit[x][0], profit[x][2]));
        }

        return res;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock obj = new BestTimeToBuyAndSellStock();
        System.out.println(obj.maxProfit_qingchao(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(obj.maxProfit_ordinary(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(obj.maxProfit_compress(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
