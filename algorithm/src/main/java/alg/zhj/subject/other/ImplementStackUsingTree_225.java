package alg.zhj.subject.other;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhaohongjie on 2020/9/6.
 */
public class ImplementStackUsingTree_225 {

    private Queue<Integer> queue = new LinkedList<>();

    public void push(int x) {
        queue.add(x);
        for (int i=1; i<queue.size(); i++)
            queue.add(queue.remove());
    }

    public void pop() {
        queue.remove();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
