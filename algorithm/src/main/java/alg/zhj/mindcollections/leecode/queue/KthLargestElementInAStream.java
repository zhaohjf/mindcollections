package alg.zhj.mindcollections.leecode.queue;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/
 *
 * Created by zhaohongjie on 2019/2/26.
 */
public class KthLargestElementInAStream {

    final PriorityQueue<Integer> q;
    final int k;

    public KthLargestElementInAStream(int k, int[] nums) {
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

    public static void main(String[] args) {
        KthLargestElementInAStream ojb = new KthLargestElementInAStream(3, new int[]{1, 3, -1, -3, 5, 3, 6, 7});
        System.out.println(ojb.add(1));
    }
}
