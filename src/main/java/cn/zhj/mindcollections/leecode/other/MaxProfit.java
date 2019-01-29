package cn.zhj.mindcollections.leecode.other;

/**
 * Created by zhaohongjie on 2019/1/28.
 */
public class MaxProfit {

    /**
     * 贪心算法：在对问题求解时，总是做出当前看来最好的选择
     *
     * 因此，这种算法在最后可能并不是最优的。
     *
     * 问题可以被分解成子问题，子问题的最优解都可以递归到全局的最优解，这种子问题称为最佳子结构。
     *
     * @param prices
     * @return
     */
    public static int maxProfit_greed(int[] prices) {

        // 总收益
        int sum = 0;
        /**
         * 以下循环还可以起到另外一个作用就是，数组判空
         * 当 prices.length 小于等于 1时，不满足条件，for循环不执行，直接返回 0.
         *
         */
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                sum += prices[i] - prices[i - 1];
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] array = {7,1,5,3,6,4};
        System.out.println(maxProfit_greed(array));
    }
}
