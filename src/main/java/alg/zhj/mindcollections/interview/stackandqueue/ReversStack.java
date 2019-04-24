package alg.zhj.mindcollections.interview.stackandqueue;

import java.util.Stack;

/**
 * P7
 *
 * Created by zhaohongjie on 2019/4/6.
 */
public class ReversStack {

    public static int getAndRemoveLastElement(Stack<Integer> stack) {

        Integer result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }

    public static void reverse(Stack<Integer> stack) {

        if (stack.isEmpty()) {
            return;
        }

        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        for (int i = 0; i < 5; i++) {
            System.out.print(stack.peek() + ", ");
        }

        reverse(stack);

        for (int i = 0; i < 5; i++) {
            System.out.print(stack.pop() + ", ");
        }
    }
}
