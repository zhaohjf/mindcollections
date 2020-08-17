package alg.zhj.subject.bit;

import java.util.Stack;

/**
 * Created by zhaohongjie on 2020/8/17.
 */
public class ToHex_405 {

    public String toHex(int num) {
        Stack<String> stack = new Stack<>();
        while (num != 0) {
            int tmp = num & 15;
            if (tmp < 10) {
                stack.push(String.valueOf(tmp));
            } else if (tmp == 10) {
                stack.push("a");
            } else if (tmp == 11) {
                stack.push("b");
            } else if (tmp == 12) {
                stack.push("c");
            } else if (tmp == 13) {
                stack.push("d");
            } else if (tmp == 14) {
                stack.push("E");
            } else if (tmp == 15) {
                stack.push("F");
            }
            num = num >>> 4;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ToHex_405 obj = new ToHex_405();
        System.out.print(obj.toHex(-1));
    }
}
