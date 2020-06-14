package alg.zhj.mindcollections.campaign.week01;

/**
 * Created by zhaohongjie on 2020/6/13.
 */
public class MyCircularDeque_641 {

    private int capacity;

    private int[] queue;

    private int front;

    private int rear;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque_641(int k) {
        // 容量上有一个空间的浪费，主要原因是我们用 front == rear 标记了空队列
        // 所以满队列 rear + 1 = front
        capacity = k + 1;
        queue = new int[capacity];
        front = 0;
        rear = 0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        front = (front - 1 + capacity) % capacity;
        queue[front] = value;

        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        queue[rear] = value;
        rear = (rear + 1) % capacity;

        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % capacity;

        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        rear = (rear - 1 + capacity) % capacity;

        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }

        return queue[front];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }

        // 当 rear 为 0 时防止数组越界
        return queue[(rear - 1 + capacity) % capacity];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return rear == front;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }
}
