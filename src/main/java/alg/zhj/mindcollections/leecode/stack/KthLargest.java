package alg.zhj.mindcollections.leecode.stack;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by zhaohongjie on 2018/12/26.
 */
public class KthLargest {

    final PriorityQueue<Integer> q;
    final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        q = new PriorityQueue<>(k);
        Arrays.stream(nums).forEach(num -> add(num));
    }

    public int add(int val) {
        if (q.size() < k) {
            q.offer(val);
        } else if (q.peek() < val) {
            q.poll();
            q.offer(val);
        }

        return q.peek();
    }

}
