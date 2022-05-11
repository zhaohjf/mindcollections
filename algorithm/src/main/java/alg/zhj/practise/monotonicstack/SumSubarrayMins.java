package alg.zhj.practise.monotonicstack;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/sum-of-subarray-minimums/
 */
public class SumSubarrayMins {

    private final int mod = (int) 1e9 + 7;

    public int sumSubarrayMins(int[] arr) {
        int len = arr.length;
        if (len == 1) {
            return arr[0];
        }
        Stack<Integer> stack = new Stack<>();
        long ans = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                Integer index = stack.pop();
                int leftRange = stack.isEmpty() ? -1 : stack.peek();
                ans += (long) (index - leftRange) * (i - index) * arr[index];
                ans %= mod;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            Integer index = stack.pop();
            int leftRange = stack.isEmpty() ? -1 : stack.peek();
            ans += (long) (index - leftRange) * (len - index) * arr[index];
            ans %= mod;
        }

        return (int) (ans %= mod);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 2, 4};
        SumSubarrayMins obj = new SumSubarrayMins();
        int ans = obj.sumSubarrayMins(arr);
        System.out.println(ans);
    }
}
