package alg.zhj.mindcollections.leecode.array;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by zhaohongjie on 2020/6/7.
 */
public class GetMaxWindow {

    /**
     * 双端队列
     * 从后端放入（从后往前看，只要比当前值小就弹出）
     * 前端出（保证滑动窗口大小）
     *
     * @param arr
     * @param w
     * @return
     */
    private static int[] getMaxWindow(int[] arr, int w) {

        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }

        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!qmax.isEmpty() && arr[qmax.peek()] <= arr[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() == i - w) {
                qmax.pollFirst();
            }
            if (i >= w - 1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] a = {4, 3, 5, 4, 3, 3, 6, 7};
        int[] res = getMaxWindow(a, 3);
        Arrays.stream(res).forEach(x -> System.out.print(x + ", "));
    }
}
