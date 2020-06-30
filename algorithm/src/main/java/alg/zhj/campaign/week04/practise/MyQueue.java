package alg.zhj.campaign.week04.practise;

import java.util.Stack;

/**
 * Created by zhaohongjie on 2020/6/29.
 */
public class MyQueue {
    private Stack<Integer> stack;
    private Stack<Integer> helper;

    /** Initialize your data structure here. */
    public MyQueue() {
        this.stack = new Stack<>();
        this.helper = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        helper.clear();
        while (!stack.isEmpty()) {
            helper.push(stack.pop());
        }
        int res = helper.pop();
        while (!helper.isEmpty()) {
            stack.push(helper.pop());
        }
        return res;
    }

    /** Get the front element. */
    public int peek() {
        helper.clear();
        while (!stack.isEmpty()) {
            helper.push(stack.pop());
        }
        int ans = helper.peek();
        while (!helper.isEmpty()) {
            stack.push(helper.pop());
        }
        return ans;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.peek();  // 返回 1
        queue.pop();   // 返回 1
        queue.empty(); // 返回 false\
    }
}
