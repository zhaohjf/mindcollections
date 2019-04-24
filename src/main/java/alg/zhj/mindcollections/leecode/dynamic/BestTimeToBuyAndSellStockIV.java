package alg.zhj.mindcollections.leecode.dynamic;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
 *
 * Created by zhaohongjie on 2019/2/22.
 */
public class BestTimeToBuyAndSellStockIV {

    /**
     * profit[i][k][j] —— 前i个价格中，交易k次的最大化利润
     *    i —— 表示前[0~i]个价格
     *    k —— 表示第几次交易
     *    j —— 表示当前是否持仓，0，没有持仓；1，有持仓
     *
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {

        int res = 0;

        if (prices == null || prices.length <= 1 || k <= 0) {
            return res;
        }

        long[][][] profit = new long[prices.length][k+1][2];

        profit[0][0][0] = 0;
        profit[0][0][1] = -prices[0];
        for (int i = 1; i <= k; i++) {
            profit[0][i][0]=Integer.MIN_VALUE;
            profit[0][i][1]=Integer.MIN_VALUE;
        }

        for (int i = 1; i < prices.length; i++) {
            profit[i][0][0] = profit[i - 1][0][0];
            profit[i][0][1] = Math.max(profit[i - 1][0][1], profit[i - 1][0][0] - prices[i]);
            for (int j = 1; j <= k; j++) {
                profit[i][j][0] = Math.max(profit[i - 1][j][0], profit[i - 1][j - 1][1] + prices[i]);
                profit[i][j][1] = Math.max(profit[i - 1][j][1], profit[i - 1][j][0] - prices[i]);
            }
        }

        for (int i = 0; i <= k; i++) {
            res = Math.max(res, (int) profit[prices.length - 1][i][0]);
        }

        return res;
    }

    public int maxProfit_compress(int k, int[] prices) {

        int res = 0;

        if (prices == null || prices.length <= 1 || k <= 0) {
            return res;
        }

        /**
         * 由于每交易一次会占用两个价格，因此，当k >= prices.length时，问题就退化为求任意次交易情况下最大收益的贪心算法
         *
         */
        if(k >= prices.length/2) return greedy(prices);

        long[][][] profit = new long[2][k + 1][2];

        profit[0][0][0] = 0;
        profit[0][0][1] = -prices[0];
        for (int i = 1; i <= k; i++) {
            profit[0][i][0]=Integer.MIN_VALUE;
            profit[0][i][1]=Integer.MIN_VALUE;
        }

        for (int i = 1; i < prices.length; i++) {
            int x = i % 2;
            int y = (i - 1) % 2;
            profit[x][0][0] = profit[y][0][0];
            profit[x][0][1] = Math.max(profit[y][0][1], profit[y][0][0] - prices[i]);
            for (int j = 1; j <= k; j++) {
                profit[x][j][0] = Math.max(profit[y][j][0], profit[y][j - 1][1] + prices[i]);
                profit[x][j][1] = Math.max(profit[y][j][1], profit[y][j][0] - prices[i]);

                res = Math.max(res, (int) profit[x][j][0]);
            }
        }

        return res;
    }

    private int greedy(int[] prices) {
        int max = 0;
        for(int i = 1; i < prices.length; ++i) {
            if(prices[i] > prices[i-1])
                max += prices[i] - prices[i-1];
        }
        return max;
    }

    public int maxProfit_discussion(int k, int[] prices) {

        // 当k大于prices数组长度的一半时
        if (k >= prices.length >>> 1) {
            int T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;

            for (int price : prices) {
                int T_ik0_old = T_ik0;
                T_ik0 = Math.max(T_ik0, T_ik1 + price);
                T_ik1 = Math.max(T_ik1, T_ik0_old - price);
            }

            return T_ik0;
        }

        int[] T_ik0 = new int[k + 1];
        int[] T_ik1 = new int[k + 1];
        Arrays.fill(T_ik1, Integer.MIN_VALUE);

        for (int price : prices) {
            for (int j = k; j > 0; j--) {
                T_ik0[j] = Math.max(T_ik0[j], T_ik1[j] + price);
                T_ik1[j] = Math.max(T_ik1[j], T_ik0[j - 1] - price);
            }
        }

        return T_ik0[k];
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockIV obj = new BestTimeToBuyAndSellStockIV();
        System.out.println(obj.maxProfit(2, new int[]{3,2,6,5,0,3}));
        System.out.println(obj.maxProfit_compress(2, new int[]{3,2,6,5,0,3}));
        System.out.println(obj.maxProfit_discussion(2, new int[]{3,2,6,5,0,3}));
    }

}
