package alg.zhj.mindcollections.leecode.queue;

import java.util.*;

/**
 * Created by zhaohongjie on 2018/12/29.
 */
public class SlidingWindowMaximum {

    /**
     * 使用数组的时间复杂度要远小于使用List的时间复杂度
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {

        // 保存数组的下标
        Deque<Integer> window = new ArrayDeque<>();
        int[] res = new int[nums.length + 1 - k];

        if (nums == null || nums.length <= 0) {
            return nums;
        }

        for (int i = 0; i < nums.length; i++) {

            // 队列头一个元素的下标，如果超出窗口，就删除
            if (i >= k && window.peekFirst() <= i - k) {
                window.pollFirst();
            }

            // 从后往前，如果有元素小于当前值，则删除这个元素
            while (!window.isEmpty() && nums[window.peekLast()] <= nums[i]) {
                window.pollLast();
            }
            window.add(i);

            if (i >= k - 1) {
                res[i- k + 1] = nums[window.peekFirst()];
            }
        }

        return res;
    }


    public static void main(String[] args) {
        int[] nums = {1, 3, 1, 2, 0, 5};
        int k = 3;

        int[] res = maxSlidingWindow(nums, k);

        for (int i : res) {
            System.out.println(i);
        }
    }
}
