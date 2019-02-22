package cn.zhj.mindcollections.leecode.dynamic;

import java.lang.management.ManagementFactory;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 *
 * Created by zhaohongjie on 2019/2/21.
 */
public class BestTimeToBuyAndSellStockII {

    /**
     * profit[i][0~2] 表示前i个数中，0——没有持仓，1——买入，2——卖出情况下的最大收益
     *
     * 状态递推公式，见下面循环体
     * profit[i][0] = max(前i - 1价格中当前没有持仓的最大利润，前i - 1个价格中有持仓的情况下以当前价格卖出)
     *
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

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
            profit[i][0] = Math.max(profit[i - 1][0], profit[i - 1][1] + prices[i]);
            profit[i][1] = Math.max(profit[i - 1][1], profit[i - 1][0] - prices[i]);
            profit[i][2] = Math.max(profit[i - 1][2], profit[i - 1][1] + prices[i]);

            res = Math.max(res, Math.max(profit[i][0], profit[i][2]));
        }

        return res;
    }

    /**
     * 状态压缩
     *
     * 买入时，利润要减去买入价
     *
     * @param prices
     * @return
     */
    public int maxProfit_ordinary(int[] prices) {

        int res = 0;

        if (prices == null || prices.length <= 1) {
            return res;
        }

        int[][] profit = new int[2][2];

        profit[0][0] = 0;
        profit[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {

            int x = i % 2;
            int y = (i - 1) % 2;

            profit[x][0] = Math.max(profit[y][0], profit[y][1] + prices[i]);
            profit[x][1] = Math.max(profit[y][1], profit[y][0] - prices[i]);

            res = Math.max(res, profit[x][0]);
        }

        return res;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockII obj = new BestTimeToBuyAndSellStockII();
        System.out.println(obj.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(obj.maxProfit_ordinary(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
