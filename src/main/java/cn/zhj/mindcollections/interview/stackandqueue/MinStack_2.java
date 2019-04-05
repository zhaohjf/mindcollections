package cn.zhj.mindcollections.interview.stackandqueue;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/min-stack/
 *
 * Created by zhaohongjie on 2019/4/5.
 */
public class MinStack_2 {

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MinStack_2() {
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public void push(int x) {

        if (this.stackMin.empty() || x <= this.getMin()) {
            this.stackMin.push(x);
        } else {
            this.stackMin.push(this.stackMin.peek());
        }

        stackData.push(x);
    }

    public int pop() {

        if (this.stackData.isEmpty()) {
            throw new RuntimeException("Your stack is empty.");
        }

        this.stackMin.pop();

        return this.stackData.pop();
    }

    public int top() {

        if (this.stackData.empty()) {
            throw new RuntimeException("Your stack is empty.");
        }

        return this.stackData.peek();
    }

    public int getMin() {

        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("Your stack is empty.");
        }

        return stackMin.peek();
    }
}
