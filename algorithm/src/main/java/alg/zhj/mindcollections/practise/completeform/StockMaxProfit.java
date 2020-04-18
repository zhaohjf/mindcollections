package alg.zhj.mindcollections.practise.completeform;

/**
 * 动态规划算法见
 * {@link alg.zhj.mindcollections.leecode.dynamic.BestTimeToBuyAndSellStockWithTransactionFee}
 *
 * Created by zhaohongjie on 2020/4/18.
 */
public class StockMaxProfit {

    public int maxProfit(int[] prices, int fee) {
        int length = prices.length;
        int keepMax = -prices[0];
        int notKeepMax = 0;

        for (int i = 1; i < length; i++) {
            int keepMaxYesterday = keepMax;
            keepMax = Math.max(keepMax, notKeepMax - prices[i]);
            notKeepMax = Math.max(notKeepMax, keepMaxYesterday + prices[i] - fee);
        }
        return notKeepMax;
    }

    public static void main(String[] args) {
        StockMaxProfit obj = new StockMaxProfit();
        int res = obj.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2);
        System.out.println(res);
    }
}
