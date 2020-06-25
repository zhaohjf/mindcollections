package alg.zhj.campaign.week03.practise;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by zhaohongjie on 2020/6/24.
 */
public class FinalPrices_monotonicStack_1475 {

    public int[] finalPrices(int[] prices) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < prices.length; i ++) {
            while (!st.isEmpty() && prices[st.peek()] >= prices[i]) {
                prices[st.pop()] -= prices[i];
            }
            st.push(i);
        }
        return prices;
    }

    public static void main(String[] args) {
        int[] a = {8, 4, 6, 2, 3};
        FinalPrices_monotonicStack_1475 obj = new FinalPrices_monotonicStack_1475();
        Arrays.stream(obj.finalPrices(a)).forEach(x -> System.out.print(x + ", "));
    }
}
