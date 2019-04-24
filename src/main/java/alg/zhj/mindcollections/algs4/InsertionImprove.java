package alg.zhj.mindcollections.algs4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by zhaohongjie on 2018/6/24.
 */
public class InsertionImprove {

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            Comparable target = a[i];
            int index = i;
            for (int j = i; j > 0; j--) {
                if (less(target, a[j - 1])) {
                    a[j] = a[j - 1];
                    index = j - 1;
                } else {
                    break;
                }
            }
            a[index] = target;
            assert isSorted(a, 0, i);
        }
        assert isSorted(a);
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[10];
        for (int i = 0; i < 10; i++) {
            //a[i] = 10 - i;
            a[i] = StdRandom.uniform(1, 30);
        }
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
        StdOut.println("===========");
        sort(a);
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }
}
