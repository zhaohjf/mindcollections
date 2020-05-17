package alg.zhj.mindcollections.leecode.multithread;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * Created by zhaohongjie on 2020/5/17.
 */
public class ZeroEvenOdd_2 {

    private int n;
    Semaphore s1, s2, s3;

    public ZeroEvenOdd_2(int n) {
        this.n = n;
        s1 = new Semaphore(1);
        s2 = new Semaphore(0);
        s3 = new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            s1.acquire();
            printNumber.accept(0);
            if (i % 2 == 0) {
                s3.release();
            } else {
                s2.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            s2.acquire();
            printNumber.accept(i);
            s1.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            s3.acquire();
            printNumber.accept(i);
            s1.release();
        }
    }
}
