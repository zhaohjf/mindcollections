package alg.zhj.mindcollections.leecode.array;

// Say you have an array for which the ith element is the price of a given stock on day i.

// If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

// Example 1:
// Input: [7, 1, 5, 3, 6, 4]
// Output: 5

// max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
// Example 2:
// Input: [7, 6, 4, 3, 1]
// Output: 0

// In this case, no transaction is done, i.e. max profit = 0.

/**
 * Created by zhaohongjie on 2018/10/15.
 */
public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {
        //Kadane's algorithm
        if(prices.length == 0) {
            return 0;
        }

        int min = prices[0];
        int max = 0;

        /**
         * 优点：只遍历了一遍数组
         *
         * 逻辑：
         * 1，从头开始遍历数组，第一个元素为min，从第二个元素开始遍历；
         * 2，当前元素<min，min=当前元素；当前元素>min，计算max
         *
         * 思路：
         *    使用了两个指针：一个指针用来遍历数组，另一个指针指向已遍历集合中的最小元素；
         *    最大值的计算就是通过这两个指针来完成的——
         *    当前被遍历元素减去已遍历的最小元素，记录其最大值为最终结果
         *
         * 需要注意的是：这是一个股票价格序列数组，要确保的你的买价小于卖价才有可能盈利；因此，最小元素指针会永远在当前遍历指针位置之前，最大
         * 收益计算也必须是用后面的元素（当前指针遍历位置）减去前面的元素（最小元素指针位置）
         *
         */
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > min) {
                max = Math.max(max, prices[i] - min);
            } else {
                min = prices[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] a = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(a));
    }
}
