package alg.zhj.campaign.week02.src;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by zhaohongjie on 2020/6/18.
 */
public class TopKFrequent_347 {

    public int[] topKFrequent(int[] nums, int k) {

        if (nums == null || nums.length < k) {
            return new int[0];
        }

        Map<Integer, Integer> count = new HashMap<>();
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>((n1, n2) -> count.get(n1) - count.get(n2));
        for (int c : count.keySet()) {
            heap.offer(c);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] ans = new int[k];
        int i = 0;
        while (!heap.isEmpty()) {
            Integer r = heap.poll();
            ans[i] = r;
            i++;
        }

        return ans;
    }

    /**
     * 解法2，桶排序
     *
     * 桶排序的时间比较上面算法要小1/4
     *
     * @param
     */
    public int[] _topKFrequent(int[] nums, int k) {

        if (nums == null || nums.length < k) {
            return new int[0];
        }

        Map<Integer, Integer> count = new HashMap<>();
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];
        for (int key : count.keySet()) {
            Integer frequency = count.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        int[] ans = new int[k];
        int num = 0;
        for (int i = bucket.length - 1; i >= 0 && num < k; i--) {
            if (bucket[i] != null) {
                for (int item : bucket[i]) {
                    ans[num++] = item;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 2, 2, 3};
        TopKFrequent_347 obj = new TopKFrequent_347();
        int[] ans = obj._topKFrequent(a, 2);
        Arrays.stream(ans).forEach(System.out::print);
    }
}
