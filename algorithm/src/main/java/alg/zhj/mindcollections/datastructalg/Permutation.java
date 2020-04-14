package alg.zhj.mindcollections.datastructalg;

/**
 * Created by zhaohongjie on 2020/4/14.
 */
public class Permutation {

    /**
     * 同理 {@link alg.zhj.mindcollections.mathematics.Lesson7_2} 都是求全排列
     *
     * 下面是用了回溯
     *
     * @param data
     * @param n
     * @param k
     */
    public static void printPermutations(int[] data, int n, int k) {

        if (k == 1) {
            for (int i = 0; i < n; ++i) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < k; ++i) {
            int tmp = data[i];
            data[i] = data[k-1];
            data[k-1] = tmp;

            printPermutations(data, n, k - 1);

            tmp = data[i];
            data[i] = data[k-1];
            data[k-1] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        printPermutations(a, 3, 3);
    }
}
