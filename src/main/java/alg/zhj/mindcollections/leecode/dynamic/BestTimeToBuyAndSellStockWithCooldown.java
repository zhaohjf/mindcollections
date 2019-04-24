package alg.zhj.mindcollections.leecode.dynamic;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 *
 * Created by zhaohongjie on 2019/2/23.
 */
public class BestTimeToBuyAndSellStockWithCooldown {

    /**
     * profit[i][k][j]
     *    i —— 表示前[0~i]个价格
     *    k —— 是否在冷冻期 0，否；1，是
     *    j —— 表示当前是否持仓，0，没有持仓 或 卖出；1，有持仓
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        int res = 0;

        if (prices == null || prices.length <= 1) {
            return res;
        }

        long[][][] profit = new long[2][2][2];

        profit[0][0][0] = 0;
        profit[0][0][1] = -prices[0];
        profit[0][1][0] = Integer.MIN_VALUE;
        profit[0][1][1] = Integer.MIN_VALUE;

        for (int i = 1; i < prices.length; i++) {

            int x = i % 2;
            int y = (i - 1) % 2;

            profit[x][0][0] = Math.max(profit[y][0][0], profit[y][1][0]);
            profit[x][0][1] = Math.max(profit[y][0][1], profit[y][0][0] - prices[i]);

            profit[x][1][0] = Math.max(profit[y][1][0], profit[y][0][1] + prices[i]);
            profit[x][1][1] = profit[y][1][1];

            res = Math.max(res, (int) Math.max(profit[x][0][0], profit[x][1][0]));
        }

        return res;
    }

    public int maxProfit_discussion1(int[] prices) {
        if(prices.length==0)return 0;
        int[] dp1=new int[prices.length];
        int[] dp2=new int[prices.length];
        dp2[0]=0;
        dp1[0]=-prices[0];
        for(int i=1;i<prices.length;i++){
            dp1[i]=Math.max(dp1[i-1],i>=2?dp2[i-2]-prices[i]:-prices[i]);
            dp2[i]=Math.max(dp2[i-1],dp1[i-1]+prices[i]);
        }
        return dp2[prices.length-1];
    }

    public int maxProfit_discussion2(int[] prices) {
        if(prices==null || prices.length<=1)    return 0;
        int len=prices.length;
        int[] sell=new int[len];
        int[] buy=new int[len];
        sell[0]=0;
        buy[0]=-prices[0];
        sell[1]=Math.max(prices[1]-prices[0],sell[0]);
        buy[1]=Math.max(-prices[1],-prices[0]);
        for(int i=2;i<len;i++){
            sell[i]=Math.max(sell[i-1],buy[i-1]+prices[i]);
            buy[i]=Math.max(buy[i-1],sell[i-2]-prices[i]);
        }
        return sell[len-1];
    }


    public static void main(String[] args) {
        BestTimeToBuyAndSellStockWithCooldown obj = new BestTimeToBuyAndSellStockWithCooldown();
        System.out.println(obj.maxProfit(new int[]{1,2,3,0,2}));
        System.out.println(obj.maxProfit_discussion1(new int[]{1,2,3,0,2}));
        System.out.println(obj.maxProfit_discussion2(new int[]{1,2,3,0,2}));
    }

}
