package alg.zhj.mindcollections.datastructalg;

import java.util.Arrays;

/**
 * Created by zhaohongjie on 2020/4/19.
 */
public class HeapSort {

    public static void buildHeap(int[] a, int n) {
        if (a == null) {
            return;
        }

        for (int i = (n - 1) / 2; i >= 0; --i) {
            heapify(a, n, i);
        }
    }

    private static void heapify(int[] a, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 + 1 <= n && a[i] < a[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            /**
             * 这里自己写了个坑 maxPos += 1;
             *
             * 如果上面if语句没有执行，下面if里这么写就是有问题的
             *
             */
            if (i * 2 + 2 <= n && a[maxPos] < a[i * 2 + 2]) {
                maxPos = i * 2 + 2;
            }
            if (maxPos == i) {
                break;
            }
            swap(a, i, maxPos);
            i = maxPos;
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void sort(int[] a, int n) {
        buildHeap(a, n);
        int k = n;
        while (k > 0) {
            swap(a, k, 0);
            --k;
            heapify(a, k, 0);
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 5, 9, 1, 8, 7};
        sort(a, 6);
        Arrays.stream(a).forEach(System.out::println);
    }
}
