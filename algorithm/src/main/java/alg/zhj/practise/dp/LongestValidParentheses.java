package alg.zhj.practise.dp;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/longest-valid-parentheses/
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        char[] sc = s.toCharArray();
        int count = 0;
        for (int i = 0; i < sc.length; i++) {
           if (sc[i] == '(') {
               stack.push(i);
           } else {
               stack.pop();
               if (stack.isEmpty()) {
                   stack.push(i);
               } else {
                   count = Math.max(count, i - stack.peek());
               }
           }
        }
        return count;
    }

    public static void main(String[] args) {
        LongestValidParentheses obj = new LongestValidParentheses();
        System.out.println(obj.longestValidParentheses("()(()"));
    }
}
