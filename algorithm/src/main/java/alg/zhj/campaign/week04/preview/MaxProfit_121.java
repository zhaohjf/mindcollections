package alg.zhj.campaign.week04.preview;

/**
 * Created by zhaohongjie on 2020/6/28.
 */
public class MaxProfit_121 {

    public int maxProfit(int[] prices) {
        if (prices == null) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            ans = Math.max(ans, prices[i] - min);
        }
        return ans;
    }

    /**
     * 动态规则
     *
     * @param prices
     * @return
     */
    public int _maxProfit(int[] prices) {
        int ans = 0;
        if (prices == null || prices.length <= 0) {
            return ans;
        }
        int[][] profit = new int[prices.length][3];
        profit[0][0] = 0; // 第0天没有买入
        profit[0][1] = -prices[0]; // 第0天买入
        profit[0][2] = 0; // 第0天卖出(因为是第0天，所以不存在卖出操作)
        for (int i = 1; i < prices.length; i++) {
            profit[i][0] = profit[i - 1][0];
            profit[i][1] = Math.max(profit[i - 1][1], profit[i - 1][0] - prices[i]);
            profit[i][2] = profit[i - 1][1] + prices[i];
            ans = Math.max(ans, Math.max(profit[i][0], profit[i][2]));
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {7, 1, 5, 3, 6, 4};
        MaxProfit_121 obj = new MaxProfit_121();
        int i = obj.maxProfit(a);
        System.out.print(i);
    }
}
