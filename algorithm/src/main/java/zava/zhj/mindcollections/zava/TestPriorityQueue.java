package zava.zhj.mindcollections.zava;

import alg.zhj.mindcollections.interview.linkedlist.ListNode;

import java.util.PriorityQueue;

/**
 * Created by zhaohongjie on 2020/6/21.
 */
public class TestPriorityQueue {

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(2);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(1);

        System.out.println(queue);
    }
}
