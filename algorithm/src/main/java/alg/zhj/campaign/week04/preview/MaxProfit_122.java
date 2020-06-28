package alg.zhj.campaign.week04.preview;

/**
 * Created by zhaohongjie on 2020/6/28.
 */
public class MaxProfit_122 {

    public int maxProfit(int[] prices) {
        int ans = 0;
        if(prices == null || prices.length <= 0) {
            return ans;
        }
        int[][] profit = new int[prices.length][3];
        profit[0][0] = 0;
        profit[0][1] = -prices[0];
        profit[0][2] = 0;
        for (int i = 1; i < prices.length; i++) {
            profit[i][0] = Math.max(profit[i - 1][0], profit[i - 1][1] + prices[i]);
            profit[i][1] = Math.max(profit[i - 1][1], profit[i - 1][0] - prices[i]);
            profit[i][2] = Math.max(profit[i - 1][2], profit[i - 1][1] + prices[i]);
            ans = Math.max(ans, Math.max(profit[i][0], profit[i][2]));
        }
        return ans;
    }

    public int _maxProfit(int[] prices) {
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxprofit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            peak = prices[i];
            maxprofit += peak - valley;
        }
        return maxprofit;
    }

    /**
     * 贪心 局部最优解
     *
     * @param prices
     * @return
     */
    public int _greed_maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
}
