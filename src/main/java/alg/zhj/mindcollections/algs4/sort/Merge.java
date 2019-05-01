package alg.zhj.mindcollections.algs4.sort;

/**
 * Created by zhaohongjie on 2019/4/24.
 */
public class Merge {

    private Comparable[] aux;

    public void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int lo, int hi) {

        if (hi <= lo) {
            return;
        }

        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    /**
     * 合并算法
     * 这个实现的逻辑清晰，多看多记忆，可以当作一个代码模板
     *
     * @param a
     * @param aux
     * @param lo
     * @param mid
     * @param hi
     */
    private void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {

        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * main method
     *
     * @param args
     */
    public static void main(String[] args) {
        Merge merge = new Merge();
        Integer[] a = {1, 3, 2, 8, 5, 4};
        merge.sort(a);

        for (Integer i : a) {
            System.out.print(i + ", ");
        }
    }
}
