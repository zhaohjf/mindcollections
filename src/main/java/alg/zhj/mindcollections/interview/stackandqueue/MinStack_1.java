package alg.zhj.mindcollections.interview.stackandqueue;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/min-stack/
 *
 * Created by zhaohongjie on 2019/4/5.
 */
public class MinStack_1 {

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MinStack_1() {
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public void push(int x) {

        if (this.stackMin.isEmpty() || x <= this.getMin()) {
            stackMin.push(x);
        }

        this.stackData.push(x);
    }

    public int pop() {

        if (this.stackData.isEmpty()) {
            throw new RuntimeException("Your stack is empty.");
        }

        Integer value = this.stackData.pop();
        if (value == this.getMin()) {
            this.stackMin.pop();
        }

        return value;
    }

    public int top() {

        if (this.stackData.empty()) {
            throw new RuntimeException("Your stack is empty.");
        }

        return stackData.peek();
    }

    public int getMin() {

        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("Your stack is empty.");
        }

        return stackMin.peek();
    }
}
