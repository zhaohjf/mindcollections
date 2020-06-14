package alg.zhj.campaign.week02.preview;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by zhaohongjie on 2020/6/14.
 */
public class GetLeastNumbers_i40 {

    public int[] getLeastNumbers(int[] arr, int k) {

        if (arr == null || k <= 0) {
            return new int[0];
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for (int a : arr) {
            queue.offer(a);
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }

        return res;
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 1};
        GetLeastNumbers_i40 obj = new GetLeastNumbers_i40();

        Arrays.stream(obj.getLeastNumbers(a, 2)).forEach(System.out::print);
    }
}
