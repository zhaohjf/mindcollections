package alg.zhj.mindcollections.leecode.dynamic;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 *
 * Created by zhaohongjie on 2019/2/23.
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {

    public int maxProfit(int[] prices, int fee) {

        int res = 0;

        if (prices == null || prices.length <= 1 || fee < 0) {
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
            profit[i][0] = Math.max(profit[i - 1][0], profit[i - 1][1] + prices[i] - fee);
            profit[i][1] = Math.max(profit[i - 1][1], profit[i - 1][0] - prices[i]);
            profit[i][2] = Math.max(profit[i - 1][2], profit[i - 1][1] + prices[i] - fee);

            res = Math.max(res, Math.max(profit[i][0], profit[i][2]));
        }

        return res;
    }

    public int maxProfit_compress(int[] prices, int fee) {
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

            profit[x][0] = Math.max(profit[y][0], profit[y][1] + prices[i] - fee);
            profit[x][1] = Math.max(profit[y][1], profit[y][0] - prices[i]);

            res = Math.max(res, profit[x][0]);
        }

        return res;
    }

    public int maxProfit_discussion(int[] prices, int fee) {
        if(prices == null || prices.length <= 1) return 0;

        int b0 = -prices[0], b1 = b0;
        int s0 = 0, s1 = 0;

        for(int i = 1; i < prices.length; i++) {
            b0 = Math.max(b1, s1 - prices[i]);
            s0 = Math.max(s1, b1 + prices[i]-fee);
            b1 = b0; s1 = s0;
        }
        return s0;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockWithTransactionFee obj = new BestTimeToBuyAndSellStockWithTransactionFee();
        System.out.println(obj.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
    }
}
