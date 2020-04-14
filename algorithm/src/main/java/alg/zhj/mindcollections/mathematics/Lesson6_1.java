package alg.zhj.mindcollections.mathematics;

import java.util.Arrays;

/**
 * 20200414 晚 练习归并排序
 *
 * Created by zhaohongjie on 2020/4/14.
 */
public class Lesson6_1 {

    public static int[] sort(int[] to_sort) {

        if (to_sort == null) {
            return new int[0];
        }

        if (to_sort.length == 1) {
            return to_sort;
        }

        int mid = to_sort.length / 2;
        int[] left = Arrays.copyOfRange(to_sort, 0, mid);
        int[] right = Arrays.copyOfRange(to_sort, mid, to_sort.length);

        left = sort(left);
        right = sort(right);

        return merge(left, right);
    }



    public static int[] merge(int[] a, int[] b) {

        if (a == null) {
            return b;
        }

        if (b == null) {
            return a;
        }

        int[] merge = new int[a.length + b.length];
        int mi = 0, ai = 0, bi = 0;
        while (ai < a.length && bi < b.length) {
            if (a[ai] <= b[bi]) {
                merge[mi] = a[ai];
                ai++;
            } else {
                merge[mi] = b[bi];
                bi++;
            }
            mi++;
        }

        while (ai < a.length) {
            merge[mi] = a[ai];
            ai++;
            mi++;
        }

        while (bi < b.length) {
            merge[mi] = b[bi];
            bi++;
            mi++;
        }

        return merge;
    }

    public static void main(String[] args) {
        int[] to_sort = {4, 3, 2, 7, 9, 1, 8, 6, 5};
        Arrays.stream(sort(to_sort)).forEach(x -> System.out.print(x + ", "));
    }
}
