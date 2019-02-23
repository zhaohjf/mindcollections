package cn.zhj.mindcollections.leecode.dynamic;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
 * <p>
 * Created by zhaohongjie on 2019/2/21.
 */
public class BestTimeToBuyAndSellStockIII {

    /**
     * profit[i][j][z]  i 天数；j 交易次数；z 持仓数量
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        int res = 0;

        if (prices == null || prices.length <= 1) {
            return res;
        }

        long[][][] profit = new long[prices.length][3][2];

        profit[0][0][0] = 0;
        profit[0][0][1] = -prices[0];
        profit[0][1][0] = Integer.MIN_VALUE;
        profit[0][1][1] = Integer.MIN_VALUE;
        profit[0][2][0] = Integer.MIN_VALUE;
        profit[0][2][1] = Integer.MIN_VALUE;

        for (int i = 1; i < prices.length; i++) {

            profit[i][0][0] = profit[i - 1][0][0];
            profit[i][0][1] = Math.max(profit[i - 1][0][1], profit[i - 1][0][0] - prices[i]);

            profit[i][1][0] = Math.max(profit[i - 1][1][0], profit[i - 1][0][1] + prices[i]);
            profit[i][1][1] = Math.max(profit[i - 1][1][1], profit[i - 1][1][0] - prices[i]);

            profit[i][2][0] = Math.max(profit[i - 1][2][0], profit[i - 1][1][1] + prices[i]);
            //profit[i][2][1]
        }

        int end = prices.length - 1;

        return (int) Math.max(profit[end][0][0], Math.max(profit[end][1][0], profit[end][2][0]));
    }

    public int maxProfit_compress(int[] prices) {

        int res = 0;

        if (prices == null || prices.length <= 1) {
            return res;
        }

        long[][][] profit = new long[2][3][2];

        profit[0][0][0] = 0;
        profit[0][0][1] = -prices[0];
        profit[0][1][0] = Integer.MIN_VALUE;
        profit[0][1][1] = Integer.MIN_VALUE;
        profit[0][2][0] = Integer.MIN_VALUE;
        profit[0][2][1] = Integer.MIN_VALUE;

        for (int i = 1; i < prices.length; i++) {

            int x = i % 2;
            int y = (i - 1) % 2;

            profit[x][0][0] = profit[y][0][0];
            profit[x][0][1] = Math.max(profit[y][0][1], profit[y][0][0] - prices[i]);

            profit[x][1][0] = Math.max(profit[y][1][0], profit[y][0][1] + prices[i]);
            profit[x][1][1] = Math.max(profit[y][1][1], profit[y][1][0] - prices[i]);

            profit[x][2][0] = Math.max(profit[y][2][0], profit[y][1][1] + prices[i]);

            res = (int) Math.max(res, Math.max(profit[x][0][0], Math.max(profit[x][1][0], profit[x][2][0])));
        }

        return res;
    }

    /**
     * The thinking is simple and is inspired by the best solution from Single Number II (I read through the discussion after I use DP).
     * Assume we only have 0 money at first;
     * 4 Variables to maintain some interested 'ceilings' so far:
     * The maximum of if we've just buy 1st stock, if we've just sold 1nd stock, if we've just buy 2nd stock, if we've just sold 2nd stock.
     * Very simple code too and work well. I have to say the logic is simple than those in Single Number II.
     *
     * @param prices
     * @return
     */
    public int maxProfit_other(int[] prices) {

        int hold1 = Integer.MIN_VALUE;
        int hold2 = Integer.MIN_VALUE;
        int release1 = 0;
        int release2 = 0;

        for (int i : prices) {                            // Assume we only have 0 money at first
            release2 = Math.max(release2, hold2 + i);     // The maximum if we've just sold 2nd stock so far.
            hold2 = Math.max(hold2, release1 - i);        // The maximum if we've just buy  2nd stock so far.
            release1 = Math.max(release1, hold1 + i);     // The maximum if we've just sold 1nd stock so far.
            hold1 = Math.max(hold1, -i);                  // The maximum if we've just buy  1st stock so far.
        }

        //Since release1 is initiated as 0, so release2 will always higher than release1.
        return release2;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockIII obj = new BestTimeToBuyAndSellStockIII();
        System.out.println(obj.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
        System.out.println(obj.maxProfit_compress(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
        System.out.println(obj.maxProfit_other(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
    }
}
